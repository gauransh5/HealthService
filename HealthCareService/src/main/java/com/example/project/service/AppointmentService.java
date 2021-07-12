package com.example.project.service;

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
	
	public Appointment addappointment(Appointment appointment)
	{
		return repo.save(appointment);
	}
	
	public List<Appointment> fetchallappointments()
	{
		return repo.findAll();
	}
	
	public Appointment fetchappointmentbyid(String id)
	{
		return repo.findById(id).get();
	}
	
	public List<Appointment> fetchallappointmentsbypatientid(String id)
	{
		return repo.findAllByPatientId(id);
	}
	
	public void deleteappointmentbyid(String id)
	{
		 repo.deleteById(id);
	}
}

