package com.example.BookWin.dto.ResponseDto;

import com.example.BookWin.Enum.DoseNo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {
    String name;
    Date dateOfAppointment;
    String appointmentNo;
    DoseNo doseNo;
    CenterResponceDto centerResponceDto;
}
