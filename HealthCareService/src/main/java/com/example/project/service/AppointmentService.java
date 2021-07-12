﻿package com.example.project.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;
import com.example.project.repository.AppointmentRepository;
import com.example.project.repository.PatientRepository;
import com.google.common.base.Optional;

@Service
public class AppointmentService {
	@Autowired 
	private AppointmentRepository repo;
	
	public String addappointment(Appointment appointment)
	{
		String m;
		try {
			repo.save(appointment);
			m = "Booking successful";
		} catch (Exception e) {
			m = "Booking failue";
		}
		return "message = " + m;
	}
	
	public List<Appointment> fetchallappointments()
	{
		return repo.findAll();
	}
	
	public Appointment fetchappointmentbyid(int id)
	{
		return repo.findByBooking_id(id);
	}
	
	public List<Appointment> fetchallappointmentsbypatientid(int id)
	{
		return repo.findAllByPatientId(id);
	}
	
	public void deleteappointmentbyid(int id)
	{
		 repo.deleteByBooking_id(id);
	}
}

