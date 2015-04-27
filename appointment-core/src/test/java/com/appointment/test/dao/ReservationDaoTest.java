package com.appointment.test.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.appointment.dao.BaseDao;
import com.appointment.dao.CounterDao;
import com.appointment.domain.Customer;
import com.appointment.domain.Reservation;

public class ReservationDaoTest {
	private static final Logger logger = Logger
			.getLogger(ReservationDaoTest.class);
	static Process p = null;

	private BaseDao<Reservation> dao;

	private CounterDao counterDao;

	protected ObjectId id = null;

	@Before
	public void setUp() throws Exception {
		// @Todo Run mongo with a test specific .js file to produce initial data
		// state
		BasicConfigurator.configure();

		dao = (BaseDao<Reservation>) MyTestApplicationContext.getInstance()
				.getBean("reservationDao");
		counterDao = (CounterDao) MyTestApplicationContext.getInstance()
				.getBean("counterDao");
	}

	@Test
	public void testReservation_Insert() throws Exception {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = dao.insert(Reservation);

		Reservation insertedRes = dao.selectByPk(insertedReservation.getId(),
				Reservation.class);
		Assert.assertNotNull(" Reservation inserted", insertedRes);
	}

	@Test
	public void testReservation_Delete() throws Exception {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = dao.insert(Reservation);

		Reservation insertedRes = dao.selectByPk(Reservation.getId(),
				Reservation.class);
		dao.delete(insertedRes, Reservation.class);
		Reservation deleteRes = dao.selectByPk(insertedReservation.getId(),
				Reservation.class);
		Assert.assertNull("Reservation deleted", deleteRes);
	}

	@Test
	public void testReservation_Find() throws Exception {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = dao.insert(Reservation);

		Reservation fetchRes = dao.selectByPk(insertedReservation.getId(),
				Reservation.class);
		Assert.assertTrue("fetched and created should be same", fetchRes
				.getId().equals(Reservation.getId()));
	}

	@Test
	public void testReservation_FindAll() throws Exception {
		Reservation Reservation = createReservation();

		List<Reservation> fetched = dao.findAll(Reservation.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testReservation_CountAll() throws Exception {
		Reservation Reservation = createReservation();

		long recordCount = dao.countAll(Reservation.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}

	@Test
	public void testReservation_Update() throws Exception {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = dao.insert(Reservation);
		Reservation.setSlot("10:00 - 11:00 ");
		Reservation fetchRes = dao.update(insertedReservation);
		Assert.assertTrue("fetched and created should be same", fetchRes
				.getId().equals(insertedReservation.getId()));
	}

	private Reservation createReservation() throws Exception {
		Reservation Reservation = new Reservation();
		Customer cus = this.createCustmer();
		Reservation.setCustomer(cus);
		Reservation.setCreateDate(new Date());
		Reservation.setSlot("9:00 - 10:00 ");
		Reservation.setId(new ObjectId());
		Reservation.setReservationDate(new Date());
		Reservation.setReservationId(counterDao
				.getNextSequence("RESERVATION_SEQ"));

		return Reservation;
	}

	private Customer createCustmer() {
		Customer customer = new Customer();
		customer.setName("amit");
		customer.setEmail("amitthapar123@gmail.com");
		customer.setId(new ObjectId());
		customer.setMobile(new Long("08803010194"));
		return customer;
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
