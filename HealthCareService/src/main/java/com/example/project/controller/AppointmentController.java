package com.example.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String addAppointment(@RequestBody Appointment appointment)
	{
		return service.addappointment(appointment);
	}
	
	@GetMapping("/appointment/list")
	public List<Appointment> fetchAllAppointments()
	{
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointments = service.fetchallappointments();
		return appointments;
	}
	
	@GetMapping("/appointment/view/{id}")
	public Appointment fetchAppointmentById(@PathVariable int id)
	{
		return service.fetchappointmentbyid(id);
	}
	
	@GetMapping("/appointment/list/{id}")
	public List<Appointment> fetchAllAppointmentsByPatientId(@PathVariable int id)
	{
		return service.fetchallappointmentsbypatientid(id);
	}
	
	@DeleteMapping("/appointment/delete/{id}")
	public void deleteAppointmentById(@PathVariable int id)
	{
		service.deleteappointmentbyid(id);
	}
	
}

