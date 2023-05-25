package com.example.BookWin.service.impl;

import com.example.BookWin.dto.RequestDto.UserRequestDto;
import com.example.BookWin.dto.ResponseDto.UserResponceDto;
import com.example.BookWin.model.User;
import com.example.BookWin.repository.UserRepository;
import com.example.BookWin.service.UserService;
import com.example.BookWin.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponceDto addUser(UserRequestDto userRequestDto) {

        //requestDto to user entity
        User user = UserTransformer.userRequestDtoToUser(userRequestDto);

        //saving user into db
        User savedUser = userRepository.save(user);

        //savedUser to UserResponceDto
        UserResponceDto userResponceDto = UserTransformer.userToUserResponceDto(savedUser);
        return userResponceDto;
    }



}
