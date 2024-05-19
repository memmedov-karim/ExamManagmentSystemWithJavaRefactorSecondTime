package com.example.ExamManagmentSystemRefactorization.repository;

import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
