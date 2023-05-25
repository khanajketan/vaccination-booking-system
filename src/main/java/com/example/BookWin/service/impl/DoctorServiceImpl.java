package com.example.BookWin.service.impl;

import com.example.BookWin.dto.RequestDto.DoctorRequestDto;
import com.example.BookWin.dto.ResponseDto.DoctorResponceDto;
import com.example.BookWin.exception.CenterNotFoundException;
import com.example.BookWin.model.Doctor;
import com.example.BookWin.model.VaccinationCenter;
import com.example.BookWin.repository.CenterRepository;
import com.example.BookWin.repository.DoctorRepository;
import com.example.BookWin.service.DoctorService;
import com.example.BookWin.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    CenterRepository centerRepository;

    @Override
    public DoctorResponceDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotFoundException{

        Optional<VaccinationCenter> optionalCenter = centerRepository.findById(doctorRequestDto.getCenterId());
        if(!optionalCenter.isPresent()){
            throw new CenterNotFoundException("center id is invalid");
        }
        VaccinationCenter center = optionalCenter.get();
        //doctorRequestDto to doctor entity
        Doctor doctor = DoctorTransformer.doctorRequestDtoToDoctor(doctorRequestDto);
        doctor.setCenter(center);

        //add doctor to current list of doctor in center
       center.getDoctors().add(doctor);

       // saved parent center to db so that child doctor is also added due to bidirectional mapping
       VaccinationCenter savedCenter = centerRepository.save(center);
        //savedDoctor to doctorResponceDto
        DoctorResponceDto doctorResponceDto = DoctorTransformer.doctorTodoctorResponceDto(doctor);

        return doctorResponceDto;
    }
}
