package com.appointment.dao;

import com.appointment.domain.Schedule;

public interface ScheduleDao extends BaseDao<Schedule> {

	Schedule getScheduleByOrgShortName(String orgShortName);
}
