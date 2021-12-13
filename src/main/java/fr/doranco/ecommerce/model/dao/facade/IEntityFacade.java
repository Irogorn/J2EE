package fr.doranco.ecommerce.model.dao.facade;

public interface IEntityFacade<T> {
	
	void add(T entity) throws Exception;
	T get(Class<T> entity, Integer id) throws Exception;
	void update(T entity) throws Exception;
	void remove(T entity) throws Exception;
}
