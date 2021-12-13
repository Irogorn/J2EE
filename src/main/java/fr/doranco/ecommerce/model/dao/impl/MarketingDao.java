package fr.doranco.ecommerce.model.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entities.dto.UserDto;
import fr.doranco.ecommerce.entities.pojo.Address;
import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.entities.pojo.ArticlesCart;
import fr.doranco.ecommerce.entities.pojo.Orders;
import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.HibernateDataSource;
import fr.doranco.ecommerce.model.dao.facade.AbstractEntityFacade;
import fr.doranco.ecommerce.model.dao.interfaces.IMarketingDao;
import fr.doranco.ecommerce.utils.Dates;

public class MarketingDao extends AbstractEntityFacade<Article> implements IMarketingDao {

	@Override
	public Map<String, List<UserDto>> getUsersByVille(String ville) throws Exception {
		Map<String, List<UserDto>> map = new Hashtable<String, List<UserDto>>();
		List<UserDto> users = new ArrayList<UserDto>();
		Session session = HibernateDataSource.getInstance().getSession();
		Query<Address> query = session.createNamedQuery("Address:getUsersByCity",Address.class);
		query.setParameter("city", ville);
		List<Address> addresses= query.list();
		for(Address a : addresses) {
			UserDto userDto = new UserDto();
			userDto.setGender(a.getUser().getGenre());
			userDto.setLastName(a.getUser().getNom());
			userDto.setFirstName(a.getUser().getPrenom());
			userDto.setDateNaissance(Dates.DateUtilToString(a.getUser().getDateNaissance()));
			userDto.setEmail(a.getUser().getEmail());
			users.add(userDto);
		}
		map.put(ville, users);
		 
		return map;
	}

	@Override
	public Map<UserDto, List<ArticlesCart>> getUsersWithNotEmptyCart() throws Exception {
		Map<UserDto, List<ArticlesCart>> map = new Hashtable<UserDto, List<ArticlesCart>>();
		Session session = HibernateDataSource.getInstance().getSession();
		Query<User> query = session.createQuery("FROM User u WHERE size(u.cart) > 0", User.class);
		List<User> users = query.list();
		for(User u : users) {
			UserDto userDto = new UserDto();
			userDto.setGender(u.getGenre());
			userDto.setLastName(u.getNom());
			userDto.setFirstName(u.getPrenom());
			userDto.setDateNaissance(Dates.DateUtilToString(u.getDateNaissance()));
			userDto.setEmail(u.getEmail());
			map.put(userDto, u.getCart());
		}
		
		return map;
	}

	@Override
	public Map<String, Integer> getNbOrdersByCity() throws Exception {
		Map<String, Integer> map = new Hashtable<String,Integer>();
		Session session = HibernateDataSource.getInstance().getSession();
		Query<Orders> query = session.createQuery("SELECT distinct o.shipmentAddress.city FROM Orders o",Orders.class);
		List<Orders> orders= query.list();
		for(Orders o : orders)
		{
			query = session.createQuery("SELECT distinct o FROM Orders o order by o.shipmentAddress.city = :city ",Orders.class);
			query.setParameter("city", o.getShipmentAddress().getCity());
			List<Orders> count = query.list();
			map.put(o.getShipmentAddress().getCity(), count.size());
			
		}
		return map;
	}

}
