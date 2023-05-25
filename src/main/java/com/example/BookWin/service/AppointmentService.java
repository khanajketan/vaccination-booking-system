package com.example.BookWin.service;

import com.example.BookWin.dto.RequestDto.AppointmentRequestDto;
import com.example.BookWin.dto.ResponseDto.AppointmentResponseDto;
import com.example.BookWin.exception.DoctorNotFoundException;
import com.example.BookWin.exception.DoseAlreadyTakenException;
import com.example.BookWin.exception.NotEligibleForDoseException;
import com.example.BookWin.exception.UserNotFoundException;

public interface AppointmentService {
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws DoctorNotFoundException, UserNotFoundException, DoseAlreadyTakenException, NotEligibleForDoseException;
}
