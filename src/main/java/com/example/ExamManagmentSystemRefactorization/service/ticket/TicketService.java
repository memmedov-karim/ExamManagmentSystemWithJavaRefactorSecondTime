package com.example.ExamManagmentSystemRefactorization.service.ticket;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforuser.UserTicketResponseDto;
import java.util.List;

public interface TicketService {

    NewTicketResponseDto addNewTicket(Long regionid, NewTicketRequestDto newTicketRequestDto);
    List<RegionTicketResponseDto> getListOfRegionTickets(Long regionid);
    List<UserTicketResponseDto> getListOfUserTickets(Long userid);


}
