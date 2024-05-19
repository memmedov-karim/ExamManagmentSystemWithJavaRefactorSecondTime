package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;

public class CenterNotFoundException extends NotFoundException {
    public CenterNotFoundException(){
        super("Center not found");
    }
}
