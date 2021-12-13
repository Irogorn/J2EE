package fr.doranco.ecommerce.metier;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entities.dto.UserDto;
import fr.doranco.ecommerce.entities.pojo.ArticlesCart;

public interface IMarketingMetier {
	Map<String,List<UserDto>> getUsersByVille(String ville) throws Exception;
	Map<UserDto,List<ArticlesCart>> getUsersWithNotEmptyCart() throws Exception;
	Map<String, Integer> getNbOrdersByCity() throws Exception;
	
	
	
}
