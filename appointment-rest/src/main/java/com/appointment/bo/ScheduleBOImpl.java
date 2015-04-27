package com.appointment.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.dao.ScheduleDao;
import com.appointment.domain.Config;
import com.appointment.domain.Schedule;
import com.appointment.util.Slot;

@Component
public class ScheduleBOImpl extends AbstractBaseBO<Schedule> implements
		ScheduleBO {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ScheduleBOImpl.class);
	@Autowired
	private ScheduleDao baseDao;

	@Override
	public Schedule modify(Schedule entity) {

		logger.debug("Update instance");
		return baseDao.update(entity);

	}

	@Override
	public List<String> getSlots(String orgShortName) {
		Schedule schedule = baseDao.getScheduleByOrgShortName(orgShortName);
		List<String> slots = createSlots( schedule);

		return slots;
	}

	private List<String> createSlots( Schedule schedule) {
		List<String> slots=null;
		if (schedule != null) {

			slots = new ArrayList<>();
			Config config = schedule.getConfig();
			int startSlotAt = config.getStartHr();
			while (startSlotAt < config.getEndHr()) {
				Slot.Builder builder = new Slot.Builder();
				slots.add(builder.addSlotStartAt(startSlotAt)
						.addSlotEndAt(startSlotAt + config.getFrequency())
						.getSlot());
				startSlotAt += config.getFrequency();
			}
		}
		return slots;
	}

}
