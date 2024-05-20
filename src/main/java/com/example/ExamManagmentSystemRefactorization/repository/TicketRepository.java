package com.example.ExamManagmentSystemRefactorization.repository;

import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findByRegion_User_Id(Long userid);

}
