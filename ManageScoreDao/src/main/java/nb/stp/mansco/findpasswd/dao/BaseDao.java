package com.util.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

import com.util.entity.Pagination;

public interface BaseDao<K extends Serializable,T extends Serializable> {

	    T load(K id);  
     
	    T get(K id);  
	      	      
	    void persist(T entity);  
	      
	    K save(T entity);  
	      
	    void saveOrUpdate(T entity);  
	      
	    void delete(K id);  
	      
	    void flush();

		List<T> findAll(); 
		
		List<T> find(final String hql,final Object...valus); 
		
		List<T> find(final String hql,Map<String, ?> values);
		
		List<T> find(final Criterion... criterions);
		
		List<T> findByProperty(final String propertyName, final Object value);
		
		T findUniqueByProperty(final String propertyName, final Object value);
		
		Pagination<T> findPage(String whereSql,Pagination pagination,Object... args);
}
