package com.example.ExamManagmentSystemRefactorization.service.download;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.springframework.core.io.InputStreamResource;

public interface DownloadService {
    public InputStreamResource downloadRegionTicketsAsCSV(Long regionid) throws IOException;
}
