package com.example.BookWin.service.impl;

import com.example.BookWin.Enum.VaccineType;
import com.example.BookWin.model.Dose1;
import com.example.BookWin.model.User;
import com.example.BookWin.service.Dose1Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1ServiceImpl implements Dose1Service {

    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {
        Dose1 dose1 = Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .type(vaccineType)
                .user(user)
                .build();
        return dose1;
    }
}
