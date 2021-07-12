package com.example.project.service;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;
import com.example.project.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	PatientRepository repo;

	public Patient addpatient(Patient patient) {
		
		return repo.save(patient);
	}

	public List<Patient> fetchallpatients() {
		return repo.findAll();
	}

	public Patient fetchpatientbyid(String id) {
		return repo.findById(id).get();
	}

	public void deletepatientbyid(String id) {
		 repo.deleteById(id);
	}
}

