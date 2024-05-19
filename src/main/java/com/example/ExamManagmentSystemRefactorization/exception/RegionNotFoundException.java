package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;

public class RegionNotFoundException extends NotFoundException {
    public RegionNotFoundException(){
        super("Region not found");
    }
}
