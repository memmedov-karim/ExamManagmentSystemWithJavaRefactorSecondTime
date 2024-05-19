package com.example.ExamManagmentSystemRefactorization.dto.center.newcenter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCenterRequestDto {
    @NotBlank(message = "Name is reruired")
    private String name;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Code is required")
    private String code;
}
