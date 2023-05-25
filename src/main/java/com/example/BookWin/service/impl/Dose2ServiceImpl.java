package com.example.BookWin.service.impl;

import com.example.BookWin.Enum.VaccineType;
import com.example.BookWin.model.Dose2;
import com.example.BookWin.model.User;
import com.example.BookWin.service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {
        Dose2 dose2 = Dose2.builder()
                .user(user)
                .type(vaccineType)
                .doseId(String.valueOf(UUID.randomUUID()))
                .build();
        return dose2;
    }
}
