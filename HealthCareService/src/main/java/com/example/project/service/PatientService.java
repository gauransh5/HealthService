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

	public String addpatient(Patient patient) {
		String m;
		try {
			repo.save(patient);
			m = "Registration successful";
		} catch (Exception e) {
			m = "Registration failue";
		}
		return "message = " + m;
	}

	public List<Patient> fetchallpatients() {
		return repo.findAll();
	}

	public Patient fetchpatientbyid(int id) {
		return repo.findByPatient_Id(id);
	}

	public void deletepatientbyid(int id) {
		 repo.deleteByPatient_Id(id);
	}
}

