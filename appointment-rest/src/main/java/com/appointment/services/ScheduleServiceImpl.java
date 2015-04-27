package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.BaseBO;
import com.appointment.bo.ScheduleBO;
import com.appointment.domain.Schedule;


@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	private static final Logger logger = Logger
			.getLogger(ScheduleServiceImpl.class);
	@Autowired
	private ScheduleBO baseBO;

	@Override
	public Schedule get(ObjectId id) {
		logger.debug("Getting a stored Schedule instance");
		Schedule Schedule = baseBO.get(id, Schedule.class);
		return Schedule;
	}
	@Override
	public Schedule add(Schedule sch) {
		logger.debug("Adding a new Schedule instance");
		Schedule Schedule = baseBO.add(sch);
		return Schedule;
	}
	@Override
	public Schedule modify(Schedule sch) {
		logger.debug("Modifying the Schedule instance");
		Schedule Schedule = baseBO.add(sch);
		return Schedule;
	}

	@Override
	public List<Schedule> getAll(Class<Schedule> entityClass) {
		logger.debug("Getting all the Schedules");
		List<Schedule> fetched = baseBO.getAll(Schedule.class);
		return fetched;
	}
	@Override
	public Long countAll(Class<Schedule> entityClass) {
		logger.debug("Counting the Schedules");
		long recordCount = baseBO.countAll(Schedule.class);
		return recordCount;
	}
	@Override
	public void remove(Schedule entity, Class<Schedule> entityClass) {
		logger.debug("removing the Schedule");
		baseBO.remove(entity, entityClass);
	
	}
	@Override
	public List<String> getSlots(String orgShortName) {
		return baseBO.getSlots(orgShortName);
	}

}
