package com.example.ExamManagmentSystemRefactorization.service.auth.region;

import com.example.ExamManagmentSystemRefactorization.dto.region.regionlogin.RegionLoginRequestDto;
import jakarta.servlet.http.HttpServletResponse;

public interface RegionAuthService {
    String loginRegion(RegionLoginRequestDto regionLoginRequestDto, HttpServletResponse response);

}
