package com.example.BookWin.service;

import com.example.BookWin.dto.RequestDto.DoctorRequestDto;
import com.example.BookWin.dto.ResponseDto.DoctorResponceDto;
import com.example.BookWin.exception.CenterNotFoundException;

public interface DoctorService {

    public DoctorResponceDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotFoundException;


}
