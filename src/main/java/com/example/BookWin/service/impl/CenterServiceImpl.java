package com.example.BookWin.service.impl;

import com.example.BookWin.dto.RequestDto.CenterRequestDto;
import com.example.BookWin.dto.RequestDto.UserRequestDto;
import com.example.BookWin.dto.ResponseDto.CenterResponceDto;
import com.example.BookWin.dto.ResponseDto.UserResponceDto;
import com.example.BookWin.model.User;
import com.example.BookWin.model.VaccinationCenter;
import com.example.BookWin.repository.CenterRepository;
import com.example.BookWin.repository.UserRepository;
import com.example.BookWin.service.CenterService;
import com.example.BookWin.service.UserService;
import com.example.BookWin.transformer.CenterTransformer;
import com.example.BookWin.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;

    @Override
    public CenterResponceDto addCenter(CenterRequestDto centerRequestDto) {

        // centerRequestDto to vaccinationCenter entity
        VaccinationCenter center = CenterTransformer.centerRequestDtoToCenter(centerRequestDto);

        // Saving vaccination center to db
        VaccinationCenter savedCenter = centerRepository.save(center);

        // savedCenter to CenterResponceDto
        CenterResponceDto centerResponceDto = CenterTransformer.centerToCenterResponceDto(savedCenter);

        return centerResponceDto;
    }

}
