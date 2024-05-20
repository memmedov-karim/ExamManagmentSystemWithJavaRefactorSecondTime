package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.FileGenerationException;

public class CsvFileGenerationException extends FileGenerationException {

    public CsvFileGenerationException(String msg,Throwable c){
        super(msg,c);
    }

}
