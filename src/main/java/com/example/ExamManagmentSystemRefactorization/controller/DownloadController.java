package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.annotation.TokenParam;
import com.example.ExamManagmentSystemRefactorization.constant.ConstantVariable;
import com.example.ExamManagmentSystemRefactorization.service.download.DownloadService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/download")
public class DownloadController {
    private final DownloadService downloadService;

    @GetMapping("region/tickets/csv/{regionid}")
    public ResponseEntity<InputStreamResource> downloadRegionTickets(@TokenParam(ConstantVariable.TokenNames.REGIONTOKENNAME) Long regionid) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=region_tickets.csv");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(downloadService.downloadRegionTicketsAsCSV(regionid));
    }
}
