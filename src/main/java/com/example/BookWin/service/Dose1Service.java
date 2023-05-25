package com.example.BookWin.service;

import com.example.BookWin.Enum.VaccineType;
import com.example.BookWin.model.Dose1;
import com.example.BookWin.model.User;

public interface Dose1Service {
    public Dose1 createDose1(User user, VaccineType vaccineType);
}
