package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(){
        super("User not found");
    }
}
