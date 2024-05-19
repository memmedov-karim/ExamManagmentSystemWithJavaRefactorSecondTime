package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.AlreadyExsistException;

public class UserAlreadyExistException extends AlreadyExsistException {
    public UserAlreadyExistException(){
        super("User already exist");
    }
}
