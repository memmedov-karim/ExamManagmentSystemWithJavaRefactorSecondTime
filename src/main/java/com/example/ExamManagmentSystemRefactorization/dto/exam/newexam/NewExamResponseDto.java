package com.example.ExamManagmentSystemRefactorization.dto.exam.newexam;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewExamResponseDto {
    private String name;
    private String title;
    private String datandtime;
    private String createdAt;
    private String updatedAt;
}
