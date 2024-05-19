package com.example.ExamManagmentSystemRefactorization.dto.error;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ErrorGeneralResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    public String getTimestamp() {
        return timestamp.toString();
    }
}
