<<<<<<< HEAD
package com.appointment.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Registration;

@Component
public class RegistrationBOImpl extends AbstractBaseBO implements
		IBaseBO<Registration> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(RegistrationBOImpl.class);

	@Autowired
	private BaseDao<Registration> dao;

	public Registration add(Registration registration) {
		logger.debug("Adding a new LogItem instance");
		return dao.insert(registration);
	}

	public Registration get(ObjectId id) {
		return (Registration) dao.selectByPk(id, Registration.class);
	}

	@Override
	public List<Registration> getAll() {
		return dao.findAll(Registration.class);
	}

}
=======
package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Registration;

@Component
public class RegistrationBOImpl extends AbstractBaseBO<Registration> {

	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(RegistrationBOImpl.class);

	@Autowired
	private BaseDao<Registration> baseDao;
		
	@Override
	public Registration modify(Registration entity) {

		logger.debug("Update instance");
		return baseDao.update(entity);
		
	}
	

}
>>>>>>> 78b6884dbcbd34472affcb458f52b3bbff4881c7
