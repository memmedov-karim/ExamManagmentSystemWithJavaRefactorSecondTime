package com.example.ExamManagmentSystemRefactorization.mapper.ticket;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface TicketMapperRegionI {
    TicketMapperRegionI INSTANCE = Mappers.getMapper(TicketMapperRegionI.class);
    @Mappings({
            @Mapping(source = "region.id",target = "regionid"),
            @Mapping(source = "center.id",target = "centerid"),
            @Mapping(source = "center.name", target = "centername"),
            @Mapping(source = "center.code", target = "centercode"),
            @Mapping(source = "center.city",target = "centercity"),
            @Mapping(source = "exam.id",target = "examid"),
            @Mapping(source = "exam.name", target = "examname"),
            @Mapping(source = "exam.dateandtime", target = "examdateandtime"),
    })
    RegionTicketResponseDto ticketToRegionTicketResponseDto(Ticket ticket);

    List<RegionTicketResponseDto> ticketsToRegionTicketResponseDto(List<Ticket> tickets);

}
