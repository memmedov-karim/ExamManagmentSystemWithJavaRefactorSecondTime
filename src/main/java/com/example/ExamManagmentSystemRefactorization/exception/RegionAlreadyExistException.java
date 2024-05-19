package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.AlreadyExsistException;

public class RegionAlreadyExistException extends AlreadyExsistException {
    public RegionAlreadyExistException(String name){
        super(name+" region already exist");
    }
}
