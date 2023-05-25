package com.example.BookWin.transformer;

import com.example.BookWin.dto.RequestDto.CenterRequestDto;
import com.example.BookWin.dto.ResponseDto.CenterResponceDto;
import com.example.BookWin.model.VaccinationCenter;

public class CenterTransformer {

    public static VaccinationCenter centerRequestDtoToCenter(CenterRequestDto centerRequestDto){
        VaccinationCenter center = VaccinationCenter.builder()
                .name(centerRequestDto.getName())
                .location(centerRequestDto.getLocation())
                .type(centerRequestDto.getType())
                .build();
        return center;
    }

    public static CenterResponceDto centerToCenterResponceDto(VaccinationCenter center){
        CenterResponceDto centerResponceDto = CenterResponceDto.builder()
                .name(center.getName())
                .type(center.getType())
                .location(center.getLocation())
                .build();
        return centerResponceDto;
    }
}
