package com.example.BookWin.controller;

import com.example.BookWin.dto.RequestDto.DoctorRequestDto;
import com.example.BookWin.dto.ResponseDto.DoctorResponceDto;
import com.example.BookWin.exception.CenterNotFoundException;
import com.example.BookWin.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto){
        try{
            DoctorResponceDto doctorResponceDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity(doctorResponceDto, HttpStatus.CREATED);
        }catch (CenterNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
