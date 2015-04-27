package com.appointment;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appointment.domain.Config;
import com.appointment.domain.Schedule;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

@SuppressWarnings("deprecation")
public class ScheduleServiceTest   {

	private static final Logger logger = Logger
			.getLogger(ScheduleServiceTest.class);
	static Process p = null;
	@Autowired
	private BaseService<Schedule> service;

	protected ObjectId id = null;
	
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();

		service = (BaseService<Schedule>) MyTestApplicationContext.getInstance()
				.getBean("scheduleService");
	}

	@Test
	public void testSchedule_Insert() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);

		Schedule insertedSch = service.get(insertedSchedule.getId());
		Assert.assertNotNull(" Schedule inserted", insertedSch);
	}

	@Test
	public void testSchedule_Delete() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);

		Schedule insertedSch = service
				.get(Schedule.getId());
		service.remove(insertedSch, Schedule.class);
		Schedule deleteSch = service.get(insertedSchedule.getId());
		Assert.assertNull("Schedule deleted", deleteSch);
	}

	@Test
	public void testSchedule_Find() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);

		Schedule fetchSch = service.get(insertedSchedule.getId());
		Assert.assertTrue("fetched and created should be same", fetchSch
				.getId().equals(Schedule.getId()));
	}

	@Test
	public void testSchedule_FindAll() {
		Schedule Schedule = createSchedule();

		List<Schedule> fetched = service.getAll(Schedule.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testSchedule_CountAll() {
		Schedule Schedule = createSchedule();

		long recordCount = service.countAll(Schedule.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}
	

	@Test
	public void testSchedule_Update() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);
		insertedSchedule.setDurationId(new Long(2));
		Schedule fetchSch = service.modify(insertedSchedule);
		Assert.assertTrue("fetched and created should be same", fetchSch
				.getId().equals(insertedSchedule.getId()));
	}
	
	

private Schedule createSchedule() {
		
		Config config=createConfig();
		
		 
		
		Schedule schedule = new Schedule();
		schedule.setConfig(config);
		schedule.setDuration(config.getEndHr()-config.getEndHr()+1);
		schedule.setDurationId(new Long(1));
		schedule.setOrgShortName("RABO");
		schedule.setResourceCount(2);
		schedule.setStatus("Available");
		schedule.setId(new ObjectId("553804161b9c464c32db3f6a"));
		schedule.setThreshold((config.getFrequency()*60/config.getMinTimePerResource())*schedule.getResourceCount());
			
		return schedule;
	}
	
	private Config createConfig() {
		Config config = new Config();
		config.setEndHr(17);
		config.setFrequency(1);
		config.setMinTimePerResource(30);
		config.setResources(1);
		config.setStartHr(9);
		config.setResourcesType("Doctor");
		config.setOrgShortName("RABO");
		return config;
	}
	

	
	// @BeforeClass
	public static void beforeClass() throws Exception {

		String[] command = new String[] {
				"/D:/amit/software/mongoDB/bin/mongod", "--dbpath",
				"/D:/amit/software/mongoDB/data", "--rest" };

		ProcessBuilder pb = new ProcessBuilder(command);

		p = pb.start();

		logger.debug("Process started with pid: " + p);

	}

	// @AfterClass
	public static void afterClass() throws Exception {
		// Stop mongod process
		boolean processClosed = false;

		Thread.sleep(5000);
		p.destroy();
		if (p != null) {
			while (!processClosed) {

				try {

					processClosed = true;
					Thread.sleep(500);
					logger.info(" Process destroyed: " + p.exitValue());
				} catch (IllegalThreadStateException itse) {
					logger.warn(itse);
					processClosed = false;
				}
			}
		}

	}

}
