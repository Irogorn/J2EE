package fr.doranco.ecommerce.rest.jersey.server.service;

import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.doranco.ecommerce.entities.dto.UserDto;
import fr.doranco.ecommerce.entities.pojo.ArticlesCart;
import fr.doranco.ecommerce.model.dao.impl.MarketingDao;
import fr.doranco.ecommerce.model.dao.interfaces.IMarketingDao;

@Path("marketing")
public class MarketingService implements IMarketingService {

	private final static String CHARSET = ";charset=UTF-8";
	private IMarketingDao marketingDao = null;
	
	public MarketingService() {
		marketingDao = new MarketingDao();
	}
	
	@RolesAllowed("MARKETING")
	@GET
	@Path("users-by-{city}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET)
	@Override
	public Map<String, List<UserDto>> getUsersByVille(@PathParam("city") String city) throws Exception {
		if(city == null || city.isEmpty() )
		{
			throw new IllegalArgumentException();
		}
		return marketingDao.getUsersByVille(city);
	}
	
	@RolesAllowed("MARKETING")
	@GET
	@Path("users-with-no-empty-cart")
	@Produces(MediaType.APPLICATION_JSON+CHARSET)
	@Override
	public Map<UserDto, List<ArticlesCart>> getUsersWithNotEmptyCart() throws Exception {
		return marketingDao.getUsersWithNotEmptyCart();
	}

	@RolesAllowed("MARKETING")
	@GET
	@Path("number-orders-by-city")
	@Produces(MediaType.APPLICATION_JSON+CHARSET)
	@Override
	public Map<String, Integer> getNbOrdersByCity() throws Exception {
		return marketingDao.getNbOrdersByCity();
	}

}
