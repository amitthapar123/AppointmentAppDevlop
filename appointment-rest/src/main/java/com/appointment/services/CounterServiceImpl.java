package com.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.dao.CounterDao;

@Service("counterService")
public class CounterServiceImpl implements CounterService {

	@Autowired
	private CounterDao counterDao;

	@Override
	public long getNextSequence(String name) {

		return counterDao.getNextSequence(name);
	}

}
