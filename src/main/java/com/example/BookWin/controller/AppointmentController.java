package com.example.BookWin.controller;

import com.example.BookWin.dto.RequestDto.AppointmentRequestDto;
import com.example.BookWin.dto.ResponseDto.AppointmentResponseDto;
import com.example.BookWin.exception.DoctorNotFoundException;
import com.example.BookWin.exception.DoseAlreadyTakenException;
import com.example.BookWin.exception.NotEligibleForDoseException;
import com.example.BookWin.exception.UserNotFoundException;
import com.example.BookWin.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, DoseAlreadyTakenException, NotEligibleForDoseException {
      AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentRequestDto);
      return new ResponseEntity(appointmentResponseDto, HttpStatus.CREATED);
    }
}
