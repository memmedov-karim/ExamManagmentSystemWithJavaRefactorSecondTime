package com.example.ExamManagmentSystemRefactorization.service.ticket;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketResponseDto;

public interface TicketService {

    NewTicketResponseDto addNewTicket(Long regionid, NewTicketRequestDto newTicketRequestDto);


}
