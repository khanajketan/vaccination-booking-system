package com.example.BookWin.service;

import com.example.BookWin.Enum.VaccineType;
import com.example.BookWin.model.Dose2;
import com.example.BookWin.model.User;

public interface Dose2Service {
    public Dose2 createDose2(User user, VaccineType vaccineType);
}
