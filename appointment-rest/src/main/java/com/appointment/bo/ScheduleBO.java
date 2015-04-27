package com.appointment.bo;

import java.util.List;

import com.appointment.domain.Schedule;

public interface ScheduleBO extends BaseBO<Schedule> {
	
	List<String> getSlots(String orgShortName);

}
