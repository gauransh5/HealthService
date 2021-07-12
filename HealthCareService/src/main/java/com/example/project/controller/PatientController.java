package com.example.project.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;
import com.example.project.service.PatientService;
@RestController
public class PatientController {
	@Autowired
	PatientService service;
	
	@PostMapping("/patient/register")
	public ResponseEntity<Object> addPatient(@RequestBody Patient patient)
	{
		Patient patient2 =  service.addpatient(patient);
		if(patient2 != null) {
			return new ResponseEntity<Object>(new responseBean("Registretion successful"),HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new responseBean("Registretion fail"),HttpStatus.OK);
	}
	
	@GetMapping("/patient/list")
	public List<Patient> fetchAllPatients()
	{
		List<Patient> patients = new ArrayList<Patient>();
		patients = service.fetchallpatients();
		return patients;
	}
	
	@GetMapping("/patient/view/{id}")
	public Patient fetchPatientById(@PathVariable int id)
	{
		return service.fetchpatientbyid(id);
	}
	
	
	@DeleteMapping("/patient/delete/{id}")
	public void deletePatientById(@PathVariable int id)
	{
		service.deletepatientbyid(id);
	}
}

class patientResponseBean {
	String mesaage;
    
	public patientResponseBean(String mesaage) {
		super();
		this.mesaage = mesaage;
	}

	public String getMesaage() {
		return mesaage;
	}

	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}
	
}