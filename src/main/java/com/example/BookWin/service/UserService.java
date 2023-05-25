package com.example.BookWin.service;

import com.example.BookWin.dto.RequestDto.UserRequestDto;
import com.example.BookWin.dto.ResponseDto.UserResponceDto;
import com.example.BookWin.model.User;

public interface UserService  {
    public UserResponceDto addUser(UserRequestDto user);
}
