package com.example.ExamManagmentSystemRefactorization.dto.center.regioncenter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CenterForRegionDto {
    private Long id;
    private String name;
    private String city;
    private String code;
}
