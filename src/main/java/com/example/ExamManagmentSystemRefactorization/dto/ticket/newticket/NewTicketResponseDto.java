package com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewTicketResponseDto {
    private String examname;
    private String examdateandtime;
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
