package com.example.ExamManagmentSystemRefactorization.mapper.ticket;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import java.util.List;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public interface TicketMapperI {
    TicketMapperI INSTANCE = Mappers.getMapper(TicketMapperI.class);
    @Mappings({
            @Mapping(source = "center.name", target = "centername"),
            @Mapping(source = "center.code", target = "centercode"),
            @Mapping(source = "center.city",target = "centercity"),
            @Mapping(source = "exam.name", target = "examname"),
            @Mapping(source = "exam.dateandtime", target = "examdateandtime"),
    })
    RegionTicketResponseDto ticketToRegionTicketResponseDto(Ticket ticket);

    List<RegionTicketResponseDto> ticketsToRegionTicketResponseDto(List<Ticket> tickets);

}
