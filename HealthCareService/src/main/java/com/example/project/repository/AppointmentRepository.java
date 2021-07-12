package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Model.Appointment;
import com.google.common.base.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,String>{

	Appointment findByBooking_id(int id);

	List<Appointment> findAllByPatientId(int id);

	Optional<Appointment> deleteByBooking_id(int id);

}

