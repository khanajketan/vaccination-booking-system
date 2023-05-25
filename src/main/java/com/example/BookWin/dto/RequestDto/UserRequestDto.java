package com.example.BookWin.dto.RequestDto;

import com.example.BookWin.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String name;
    int age;
    Gender gender;
    String emailId;
    String mobNo;
}
