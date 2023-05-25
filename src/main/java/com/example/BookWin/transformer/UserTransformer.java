package com.example.BookWin.transformer;

import com.example.BookWin.dto.RequestDto.UserRequestDto;
import com.example.BookWin.dto.ResponseDto.UserResponceDto;
import com.example.BookWin.model.User;

public class UserTransformer {

    public static User userRequestDtoToUser(UserRequestDto userRequestDto){
        return User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .gender(userRequestDto.getGender())
                .emailId(userRequestDto.getEmailId())
                .mobNo(userRequestDto.getMobNo())
                .build();
    }
    public static UserResponceDto userToUserResponceDto(User user){
        return UserResponceDto.builder()
                .name(user.getName())
                .message("User added Succesfully")
                .build();
    }
}
