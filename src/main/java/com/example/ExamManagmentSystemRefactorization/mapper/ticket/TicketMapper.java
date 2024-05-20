package com.example.ExamManagmentSystemRefactorization.mapper.ticket;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforuser.UserTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public RegionTicketResponseDto mapToRegionTicketResponseDto(Ticket ticket){
        return TicketMapperRegionI.INSTANCE.ticketToRegionTicketResponseDto(ticket);
    }
    public List<RegionTicketResponseDto> mapToListRegionTicketResponseDto(List<Ticket> tickets){
        return TicketMapperRegionI.INSTANCE.ticketsToRegionTicketResponseDto(tickets);
    }

    public UserTicketResponseDto mapToUserTicketResponseDto(Ticket ticket){
        return TicketMapperUserI.INSTANCE.ticketToUserTicketResponseDto(ticket);
    }
    public List<UserTicketResponseDto> mapToListUserTicketResponseDto(List<Ticket> tickets){
        return TicketMapperUserI.INSTANCE.ticketsToUserTicketResponseDto(tickets);
    }

}
