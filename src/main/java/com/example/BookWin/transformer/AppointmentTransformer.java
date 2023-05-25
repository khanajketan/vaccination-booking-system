package com.example.BookWin.transformer;

import com.example.BookWin.dto.RequestDto.AppointmentRequestDto;
import com.example.BookWin.dto.ResponseDto.AppointmentResponseDto;
import com.example.BookWin.model.Appointment;

import java.util.Date;
import java.util.UUID;

public class AppointmentTransformer {
    public static Appointment appointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto){
        Appointment appointment = Appointment.builder()
                .doseNo(appointmentRequestDto.getDoseNo())
                .dateOfAppointment(new Date())
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .build();
        return appointment;

    }
    public static AppointmentResponseDto appointmentToAppointmentResponseDto(Appointment appointment){
        AppointmentResponseDto appointmentResponseDto = AppointmentResponseDto.builder()
                .name(appointment.getUser().getName())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .appointmentNo(appointment.getAppointmentNo())
                .doseNo(appointment.getDoseNo())
                .centerResponceDto(CenterTransformer.centerToCenterResponceDto(appointment.getDoctor().getCenter()))
                .build();
        return appointmentResponseDto;
    }
}
