package fr.doranco.ecommerce.rest.jersey.server.service;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entities.dto.UserDto;
import fr.doranco.ecommerce.entities.pojo.ArticlesCart;

public interface IMarketingService {
	Map<String,List<UserDto>> getUsersByVille( String city) throws Exception;
	
	Map<UserDto,List<ArticlesCart>> getUsersWithNotEmptyCart() throws Exception;

	Map<String, Integer> getNbOrdersByCity() throws Exception;
}
