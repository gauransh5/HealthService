package com.example.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Model.Appointment;
import com.example.project.service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	AppointmentService service;
	
	@PostMapping("/appointment/register")
	public ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment)
	{
		Appointment appointment2 =  service.addappointment(appointment);
		if(appointment2 != null) {
			return new ResponseEntity<Object>(new responseBean("Booking successful"),HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new responseBean("Booking failure"),HttpStatus.OK);
	}
	
	@GetMapping("/appointment/list")
	public List<Appointment> fetchAllAppointments()
	{
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointments = service.fetchallappointments();
		return appointments;
	}
	
	@GetMapping("/appointment/view/{id}")
	public Appointment fetchAppointmentById(@PathVariable String id)
	{
		return service.fetchappointmentbyid(id);
	}
	
	@GetMapping("/appointment/list/{id}")
	public List<Appointment> fetchAllAppointmentsByPatientId(@PathVariable String id)
	{
		return service.fetchallappointmentsbypatientid(id);
	}
	
	@DeleteMapping("/appointment/delete/{id}")
	public void deleteAppointmentById(@PathVariable String id)
	{
		service.deleteappointmentbyid(id);
	}
	
}
class responseBean {
	String messsage;
	

	public responseBean(String messsage) {
		super();
		this.messsage = messsage;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	
}

