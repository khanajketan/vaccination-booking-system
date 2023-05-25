package com.example.BookWin.controller;

import com.example.BookWin.dto.RequestDto.UserRequestDto;
import com.example.BookWin.dto.ResponseDto.UserResponceDto;
import com.example.BookWin.model.User;
import com.example.BookWin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto){

        UserResponceDto userResponceDto = userService.addUser(userRequestDto);
        return new ResponseEntity(userResponceDto,HttpStatus.CREATED);
    }
}
