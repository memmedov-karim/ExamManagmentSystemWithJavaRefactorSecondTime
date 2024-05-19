package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;

public class ExamNotFoundException extends NotFoundException {
    public ExamNotFoundException(){
        super("Exam not found");
    }
}
