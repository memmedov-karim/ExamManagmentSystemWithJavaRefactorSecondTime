package com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegionTicketResponseDto {
    private Long id;
    private Long regionid;
    private Long examid;
    private String examname;
    private String examdateandtime;
    private Long centerid;
    private String centername;
    private String centercity;
    private String centercode;
    private String clas;
    private String fenn;
    private String sector;
    private String name;
    private String surname;
    private String father;
    private String room;
    private String place;
    private String phone;
}
