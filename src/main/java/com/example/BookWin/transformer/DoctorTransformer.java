package com.example.BookWin.transformer;

import com.example.BookWin.dto.RequestDto.DoctorRequestDto;
import com.example.BookWin.dto.ResponseDto.DoctorResponceDto;
import com.example.BookWin.model.Doctor;

public class DoctorTransformer {

    public static Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){
        Doctor doctor = Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .mobNo(doctorRequestDto.getMobNo())
                .emailId(doctorRequestDto.getEmailId())
                .gender(doctorRequestDto.getGender())
                .build();
        return doctor;
    }
    public static DoctorResponceDto doctorTodoctorResponceDto(Doctor doctor){
        DoctorResponceDto doctorResponceDto = DoctorResponceDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .message("Doctor Added Successfully!")
                // get center response dto from transformer user doctor
                .centerResponceDto(CenterTransformer.centerToCenterResponceDto(doctor.getCenter()))
                .build();
        return  doctorResponceDto;
    }
}
