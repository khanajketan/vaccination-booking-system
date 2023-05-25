package com.example.BookWin.controller;

import com.example.BookWin.dto.RequestDto.CenterRequestDto;
import com.example.BookWin.dto.RequestDto.UserRequestDto;
import com.example.BookWin.dto.ResponseDto.CenterResponceDto;
import com.example.BookWin.dto.ResponseDto.UserResponceDto;
import com.example.BookWin.service.CenterService;
import com.example.BookWin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Autowired
    CenterService centerService;
    @PostMapping("/addCenter")
    public ResponseEntity addCenter(@RequestBody CenterRequestDto centerRequestDto){
        CenterResponceDto centerResponceDto = centerService.addCenter(centerRequestDto);
        return new ResponseEntity(centerResponceDto, HttpStatus.CREATED);
    }

}
