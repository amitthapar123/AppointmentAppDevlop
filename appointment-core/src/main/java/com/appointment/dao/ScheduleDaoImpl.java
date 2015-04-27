package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Schedule;

/**
 * @author Parag Shrivastava
 * 
 */
@Repository("scheduleDao")
public class ScheduleDaoImpl extends AbstractBaseDao<Schedule> implements ScheduleDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Schedule update(Schedule entity) {

				mongoTemplate.save(entity);

		return entity;
	}

	@Override
	public Schedule getScheduleByOrgShortName(String orgShortName) {
		
		Query searchQuery=new Query();
		searchQuery.addCriteria(Criteria.where("orgShortName").is(orgShortName));
		return mongoTemplate.findOne(searchQuery, Schedule.class);
	}

}
