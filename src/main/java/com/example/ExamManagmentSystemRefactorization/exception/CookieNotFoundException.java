package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;

public class CookieNotFoundException extends NotFoundException {
    public CookieNotFoundException(){
        super("Cookie not found");
    }
}
