package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.AlreadyExsistException;

public class CenterAlreadyExistException extends AlreadyExsistException {
    public CenterAlreadyExistException(String name){
        super(name+" Center already exist");
    }
}
