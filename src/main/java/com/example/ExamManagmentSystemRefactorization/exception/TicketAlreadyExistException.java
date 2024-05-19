package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.AlreadyExsistException;

public class TicketAlreadyExistException extends AlreadyExsistException {
    public TicketAlreadyExistException(){
        super("Ticket already exist");
    }
}
