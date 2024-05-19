package com.example.ExamManagmentSystemRefactorization.mapper.ticket;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public RegionTicketResponseDto mapToRegionTicketResponseDto(Ticket ticket){
        return TicketMapperI.INSTANCE.ticketToRegionTicketResponseDto(ticket);
    }
    public List<RegionTicketResponseDto> mapToListRegionTicketResponseDto(List<Ticket> tickets){
        return TicketMapperI.INSTANCE.ticketsToRegionTicketResponseDto(tickets);
    }

}
