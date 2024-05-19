package com.example.ExamManagmentSystemRefactorization.mapper;

import com.example.ExamManagmentSystemRefactorization.dto.center.regioncenter.CenterForRegionDto;
import com.example.ExamManagmentSystemRefactorization.entity.Center;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CenterMapper {

    public CenterForRegionDto mapToCenterForRegionDto(Center center){
        return CenterForRegionDto.builder()
                .id(center.getId())
                .name(center.getName())
                .city(center.getCity())
                .code(center.getCode())
                .build();
    }

    public List<CenterForRegionDto> mapToListOfCenterForRegionDto(List<Center> center){
        return center.stream().map(this::mapToCenterForRegionDto).toList();
    }

}
