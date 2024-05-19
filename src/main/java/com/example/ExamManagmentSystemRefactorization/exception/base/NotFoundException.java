package com.example.ExamManagmentSystemRefactorization.exception.base;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String msg){
        super(msg);
    }
}
