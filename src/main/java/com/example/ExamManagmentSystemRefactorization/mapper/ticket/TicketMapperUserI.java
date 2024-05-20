package com.example.ExamManagmentSystemRefactorization.mapper.ticket;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforuser.UserTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface TicketMapperUserI {
    TicketMapperUserI INSTANCE = Mappers.getMapper(TicketMapperUserI.class);
    @Mappings({
            @Mapping(source = "region.user.id",target = "userid"),
            @Mapping(source = "region.id",target = "regionid"),
            @Mapping(source = "center.id",target = "centerid"),
            @Mapping(source = "center.name", target = "centername"),
            @Mapping(source = "center.code", target = "centercode"),
            @Mapping(source = "center.city",target = "centercity"),
            @Mapping(source = "exam.id",target = "examid"),
            @Mapping(source = "exam.name", target = "examname"),
            @Mapping(source = "exam.dateandtime", target = "examdateandtime"),
    })
    UserTicketResponseDto ticketToUserTicketResponseDto(Ticket ticket);
    List<UserTicketResponseDto> ticketsToUserTicketResponseDto(List<Ticket> tickets);

}
