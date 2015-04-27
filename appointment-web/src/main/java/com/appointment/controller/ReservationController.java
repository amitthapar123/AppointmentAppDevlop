package com.appointment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.domain.Reservation;
import com.appointment.services.CounterService;
import com.appointment.services.ReservationService;

@RestController
public class ReservationController {
	private static final String SEQENCE_NAME = "RESERVATION_SEQ";
	/*
	 * @RequestMapping(value = "/{name}", method = RequestMethod.GET) public
	 * String getMovie(@PathVariable String name, ModelMap model) {
	 * 
	 * model.addAttribute("movie", name); return "list";
	 * 
	 * }
	 */
	@Autowired
	private ReservationService service;

	@Autowired
	private CounterService counterService;

	@RequestMapping(value = URIConstants.ADD_RESERVATION, method = RequestMethod.POST, headers = "Accept=application/json")
	public void addReservation(@RequestBody Reservation entity) {

		if (entity != null) {
			entity.setReservationId(counterService
					.getNextSequence(SEQENCE_NAME));
			entity.setCreateDate(new Date());

			service.add(entity);
		}

	}
}
