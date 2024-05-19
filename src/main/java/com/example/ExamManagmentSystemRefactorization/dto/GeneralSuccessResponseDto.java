package com.example.ExamManagmentSystemRefactorization.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GeneralSuccessResponseDto <T> {
    private String message;
    private T data;
}
