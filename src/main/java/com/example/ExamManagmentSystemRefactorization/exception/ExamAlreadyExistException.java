package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.AlreadyExsistException;

public class ExamAlreadyExistException extends AlreadyExsistException {
    public ExamAlreadyExistException(String msg){
        super(msg+" exam already exist");
    }
}
