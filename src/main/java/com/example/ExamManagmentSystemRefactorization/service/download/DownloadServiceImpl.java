package com.example.ExamManagmentSystemRefactorization.service.download;

import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.exception.CsvFileGenerationException;
import com.example.ExamManagmentSystemRefactorization.service.region.RegionService;
import com.example.ExamManagmentSystemRefactorization.service.ticket.TicketService;
import com.example.ExamManagmentSystemRefactorization.util.region.RegionResourceChecker;
import com.opencsv.CSVWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DownloadServiceImpl implements DownloadService{
    private final RegionService regionService;
    private final TicketService ticketService;
    private final RegionResourceChecker regionResourceChecker;
    @Override
    public InputStreamResource downloadRegionTicketsAsCSV(Long regionid){
        Region existingRegion = regionService.findRegionById(regionid);
        regionResourceChecker.ThrowExceptionIfRegionDoesnotExist(existingRegion);
        List<RegionTicketResponseDto> regionTickets = ticketService.getListOfRegionTickets(regionid);
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream))) {
            // Write header
            String[] header = {"ID", "Region ID", "Center ID", "Center Name", "Center Code", "Class", "Subject", "Sector", "Name", "Surname", "Father", "Room", "Place", "Phone", "Exam ID", "Exam Name", "Exam Date and Time"};
            writer.writeNext(header);

            // Write data rows
            for (RegionTicketResponseDto ticket : regionTickets) {
                String[] row = {
                        String.valueOf(ticket.getId()),
                        String.valueOf(ticket.getRegionid()),
                        String.valueOf(ticket.getCenterid()),
                        ticket.getCentername(),
                        ticket.getCentercode(),
                        ticket.getClas(),
                        ticket.getFenn(),
                        ticket.getSector(),
                        ticket.getName(),
                        ticket.getSurname(),
                        ticket.getFather(),
                        ticket.getRoom(),
                        ticket.getPlace(),
                        ticket.getPhone(),
                        String.valueOf(ticket.getExamid()),
                        ticket.getExamname(),
                        ticket.getExamdateandtime(),
                };
                writer.writeNext(row);
            }
            writer.flush();

            return new InputStreamResource(new ByteArrayInputStream(outputStream.toByteArray()));
        } catch (IOException e) {
            throw new CsvFileGenerationException("Failed to create CSV file", e);
        }
    }

}
