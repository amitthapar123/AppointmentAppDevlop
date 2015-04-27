package com.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.domain.Schedule;
import com.appointment.services.ScheduleService;

@RestController
public class ScheduleController {

	/*
	 * @RequestMapping(value = "/{name}", method = RequestMethod.GET) public
	 * String getMovie(@PathVariable String name, ModelMap model) {
	 * 
	 * model.addAttribute("movie", name); return "list";
	 * 
	 * }
	 */
	@Autowired
	private ScheduleService service;

	@RequestMapping(value = URIConstants.GET_ALL_SCHEDULE, method = RequestMethod.GET)
	public List<Schedule> getAllSchedules() {

		List<Schedule> schedules = service.getAll(Schedule.class);

		return schedules;
	}
	
	@RequestMapping(value = URIConstants.GET_SLOTS, method = RequestMethod.GET)
	public List<String> getSlots(@PathVariable( "orgname" ) String orgShortName){

		List<String> schedules = service.getSlots(orgShortName);

		return schedules;
	}
	@RequestMapping(value = URIConstants.ADD_SCHEDULE, method = RequestMethod.POST,headers="Accept=application/json")
	public void addSchedule(@RequestBody Schedule entity){
		
		
if(entity !=null){
	Schedule sch=new Schedule(entity.getConfig());
	sch.setDurationId(entity.getDurationId());
	sch.setOrgShortName(entity.getOrgShortName());
	sch.setResourceCount(entity.getResourceCount());
	sch.setStatus(entity.getStatus());
		service.add(sch);
}
		
	}
}
