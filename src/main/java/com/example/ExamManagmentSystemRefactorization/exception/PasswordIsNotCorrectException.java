package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.IsNotCorrectException;

public class PasswordIsNotCorrectException extends IsNotCorrectException {
    public PasswordIsNotCorrectException(){
        super("Password is not correct");
    }
}
