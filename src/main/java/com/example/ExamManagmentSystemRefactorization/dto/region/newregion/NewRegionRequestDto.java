package com.example.ExamManagmentSystemRefactorization.dto.region.newregion;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewRegionRequestDto {
    @NotBlank(message = "Username is required")
    private String username;
}
