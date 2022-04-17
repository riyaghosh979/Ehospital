package com.spring.Hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.Appointment;
import com.spring.Hospital.entity.Department;
import com.spring.Hospital.entity.User;


@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	Appointment findByDepartment(Department depart);
}