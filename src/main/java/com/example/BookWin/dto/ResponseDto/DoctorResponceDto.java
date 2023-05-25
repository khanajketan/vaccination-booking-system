package com.example.BookWin.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponceDto {
    String name;
    String emailId;
    CenterResponceDto centerResponceDto;
    String message;
}
