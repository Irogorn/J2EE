package fr.doranco.ecommerce.metier;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entities.dto.UserDto;
import fr.doranco.ecommerce.entities.pojo.ArticlesCart;
import fr.doranco.ecommerce.model.dao.impl.MarketingDao;
import fr.doranco.ecommerce.model.dao.interfaces.IMarketingDao;

public class MarkatingMetier implements IMarketingMetier {

	private final IMarketingDao marketingdao = new MarketingDao();
	
	@Override
	public Map<String, List<UserDto>> getUsersByVille(String ville) throws Exception {
		if(ville == null || ville.isEmpty()) {
			throw new IllegalArgumentException("The input parameter is not in correct format !");
		}
		return marketingdao.getUsersByVille(ville);
	}
	@Override
	public Map<UserDto, List<ArticlesCart>> getUsersWithNotEmptyCart() throws Exception {
		return marketingdao.getUsersWithNotEmptyCart();
	}
	@Override
	public Map<String, Integer> getNbOrdersByCity() throws Exception {
		return marketingdao.getNbOrdersByCity();
	}

}
