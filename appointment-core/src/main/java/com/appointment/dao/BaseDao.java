package com.appointment.dao;

import java.util.List;

import org.bson.types.ObjectId;

public interface BaseDao<T> {

	T selectByPk(ObjectId objectId, Class<T> entityClass);

	T insert(T entity);

	T update(T entity);

	List<T> findAll(Class<T> entityClass);

	Long countAll(Class<T> entityClass);

	void delete(T entity, Class<T> entityClass);
}
