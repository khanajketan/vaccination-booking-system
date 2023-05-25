package com.example.BookWin.service.impl;

import com.example.BookWin.Enum.DoseNo;
import com.example.BookWin.dto.RequestDto.AppointmentRequestDto;
import com.example.BookWin.dto.ResponseDto.AppointmentResponseDto;
import com.example.BookWin.exception.DoctorNotFoundException;
import com.example.BookWin.exception.DoseAlreadyTakenException;
import com.example.BookWin.exception.NotEligibleForDoseException;
import com.example.BookWin.exception.UserNotFoundException;
import com.example.BookWin.model.*;
import com.example.BookWin.repository.AppointmentRepository;
import com.example.BookWin.repository.DoctorRepository;
import com.example.BookWin.repository.UserRepository;
import com.example.BookWin.service.AppointmentService;
import com.example.BookWin.service.Dose1Service;
import com.example.BookWin.service.Dose2Service;
import com.example.BookWin.transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws DoctorNotFoundException, UserNotFoundException, DoseAlreadyTakenException, NotEligibleForDoseException {
        // doctor is present or not
        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if(!optionalDoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor id invalid");
        }

        // user is present or not
        Optional<User> optionalUser = userRepository.findById(appointmentRequestDto.getUserId());
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User id is invalid");
        }

        Doctor doctor = optionalDoctor.get();
        User user = optionalUser.get();
        if(appointmentRequestDto.getDoseNo() == DoseNo.DOSE1){
            if(user.isDose1Taken()){
                throw new DoseAlreadyTakenException("Dose1 is Already taken");
            }else{
                user.setDose1Taken(true);
                Dose1 dose1 = dose1Service.createDose1(user, appointmentRequestDto.getVaccineType());
                user.setDose1(dose1);
            }
        }else{
            if(!user.isDose1Taken()){
                throw new NotEligibleForDoseException("Sorry! You are not eligible for Dose2");
            }
            if(user.isDose2Taken()){
                throw new DoseAlreadyTakenException("Dose2 is Already taken");
            }else{
                user.setDose2Taken(true);
                Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDto.getVaccineType());
                user.setDose2(dose2);
            }
        }
        // RequestDto to appointment
        Appointment appointment = AppointmentTransformer.appointmentRequestDtoToAppointment(appointmentRequestDto);

        // adding appointment to that doctor

        appointment.setUser(user);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);
        doctor.getAppointments().add(savedAppointment);
        user.getAppointments().add(savedAppointment);
        doctorRepository.save(doctor);
        userRepository.save(user);

        //Sending mails to user about their dose booking
        String text = "Congrats ! "+user.getName()+" your appointment for "+ appointmentRequestDto.getDoseNo()+ " of " +appointmentRequestDto.getVaccineType()+" has been booked successfully in " +doctor.getCenter().getName()+", "+doctor.getCenter().getLocation();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backend.bookwin@gmail.com");
        message.setTo(user.getEmailId());
        message.setSubject("Appointment Booked!!");
        message.setText(text);
        emailSender.send(message);

        //Appointment to ResponseDto
        AppointmentResponseDto appointmentResponseDto = AppointmentTransformer.appointmentToAppointmentResponseDto(savedAppointment);
        return appointmentResponseDto;
    }
}
