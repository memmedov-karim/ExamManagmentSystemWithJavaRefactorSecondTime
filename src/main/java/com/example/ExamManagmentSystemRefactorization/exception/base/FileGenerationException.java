package com.example.ExamManagmentSystemRefactorization.exception.base;

public class FileGenerationException extends RuntimeException{
    public FileGenerationException(String msg,Throwable c){
        super(msg,c);
    }

}
