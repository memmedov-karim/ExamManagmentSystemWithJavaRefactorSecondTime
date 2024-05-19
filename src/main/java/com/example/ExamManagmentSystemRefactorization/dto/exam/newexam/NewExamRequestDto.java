package com.example.ExamManagmentSystemRefactorization.dto.exam.newexam;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewExamRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Date and Time is required")
    private String dateandtime;
}
