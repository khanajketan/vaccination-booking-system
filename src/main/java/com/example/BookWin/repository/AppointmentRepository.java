package com.example.BookWin.repository;

import com.example.BookWin.model.Appointment;
import com.example.BookWin.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}

