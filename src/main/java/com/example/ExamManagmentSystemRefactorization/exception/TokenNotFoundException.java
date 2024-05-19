package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;

public class TokenNotFoundException extends NotFoundException {
    public TokenNotFoundException(){
        super("Token not found");
    }
}
