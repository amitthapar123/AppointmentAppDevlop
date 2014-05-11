package com.un.dao;

import org.bson.types.ObjectId;

public interface BaseDao<T> {

	T selectByPk(ObjectId id);

	ObjectId insert(T entity);
}
