package com.example.ExamManagmentSystemRefactorization.service.utis;

import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import com.example.ExamManagmentSystemRefactorization.service.region.RegionService;
import com.example.ExamManagmentSystemRefactorization.service.ticket.TicketService;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtiseServiceImpl implements UtisService{
    private final RegionService regionService;
    @Override
    public String generateUniqueUtis(Region existingRegion,int n){
        List<Ticket> tickets = existingRegion.getTickets();
        boolean isUnique;
        String uniqueUtis;

        do {
            uniqueUtis = generateRandomUTIS(n);
            isUnique = isUtisUnique(uniqueUtis,tickets);
        } while (!isUnique);

        return uniqueUtis;
    }
    private boolean isUtisUnique(String utis, List<Ticket> tickets){
        for (Ticket ticket:tickets){
            if(ticket.getUtis().equals(utis)){
                return false;
            }
        }
        return true;
    }

    private String generateRandomUTIS(int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
