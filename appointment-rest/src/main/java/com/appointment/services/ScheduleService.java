package com.appointment.services;

import java.util.List;

import com.appointment.domain.Schedule;

public interface ScheduleService extends BaseService<Schedule> {
	List<String> getSlots(String orgShortName);
}
