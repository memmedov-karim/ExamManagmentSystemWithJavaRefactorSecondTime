package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.annotation.TokenParam;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.service.ticket.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;
    @PostMapping("add")
    public ResponseEntity<NewTicketResponseDto> addNewTicket(@TokenParam("tokenR") Long regionid, @Valid @RequestBody NewTicketRequestDto newTicketRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.addNewTicket(regionid, newTicketRequestDto));
    }
}
