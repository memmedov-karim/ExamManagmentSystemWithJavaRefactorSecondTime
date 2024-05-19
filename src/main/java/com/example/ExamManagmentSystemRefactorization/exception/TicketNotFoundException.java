package com.example.ExamManagmentSystemRefactorization.exception;

import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;

public class TicketNotFoundException extends NotFoundException {
    public TicketNotFoundException(){
        super("Ticket not found");
    }
}
