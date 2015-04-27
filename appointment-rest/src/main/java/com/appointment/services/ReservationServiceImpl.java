package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.BaseBO;
import com.appointment.domain.Reservation;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

	private static final Logger logger = Logger
			.getLogger(ReservationServiceImpl.class);
	@Autowired
	private BaseBO<Reservation> baseBO;

	@Override
	public Reservation get(ObjectId id) {
		logger.debug("Getting a stored Reservation instance");
		Reservation Reservation = baseBO.get(id, Reservation.class);
		return Reservation;
	}

	@Override
	public Reservation add(Reservation res) {
		logger.debug("Adding a new Reservation instance");
		Reservation Reservation = baseBO.add(res);
		return Reservation;
	}

	@Override
	public Reservation modify(Reservation res) {
		logger.debug("Modifying the Reservation instance");
		Reservation Reservation = baseBO.add(res);
		return Reservation;
	}

	@Override
	public List<Reservation> getAll(Class<Reservation> entityClass) {
		logger.debug("Getting all the Reservations");
		List<Reservation> fetched = baseBO.getAll(Reservation.class);
		return fetched;
	}

	@Override
	public Long countAll(Class<Reservation> entityClass) {
		logger.debug("Counting the Reservations");
		long recordCount = baseBO.countAll(Reservation.class);
		return recordCount;
	}

	@Override
	public void remove(Reservation entity, Class<Reservation> entityClass) {
		logger.debug("removing the Reservation");
		baseBO.remove(entity, entityClass);

	}

	@Override
	public int getReservationCount(String orgShortName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
