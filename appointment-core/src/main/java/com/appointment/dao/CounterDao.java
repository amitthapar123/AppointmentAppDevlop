package com.appointment.dao;

import com.appointment.domain.Counter;

public interface CounterDao extends BaseDao<Counter> {
	long getNextSequence(String name);

}
