package com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewTicketRequestDto {
    @NotNull(message = "exam value is required")
    private Long exam_id;
    @NotNull(message = "center value is required")
    private Long center_id;
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
