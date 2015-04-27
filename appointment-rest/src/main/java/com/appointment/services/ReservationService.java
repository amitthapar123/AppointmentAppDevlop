package com.appointment.services;

import com.appointment.domain.Reservation;

public interface ReservationService extends BaseService<Reservation> {
	int getReservationCount(String orgShortName);
}
