package com.example.ExamManagmentSystemRefactorization.dto.center.newcenter;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewCenterResponseDto {
    private Long id;
    private String name;
    private String city;
    private String code;
}
