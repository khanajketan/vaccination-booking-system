package com.example.BookWin.dto.RequestDto;

import com.example.BookWin.Enum.DoseNo;
import com.example.BookWin.Enum.VaccineType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {
    int doctorId;
    int userId;
    Date dateOfAppointment;
    String appointmentNo;
    DoseNo doseNo;
    VaccineType vaccineType;

}
