package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Model.Appointment;
import com.google.common.base.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String>{


	List<Appointment> findAllByPatientId(String id);


}

