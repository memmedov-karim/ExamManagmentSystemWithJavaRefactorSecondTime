package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.dto.GeneralSuccessResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.regionlogin.RegionLoginRequestDto;
import com.example.ExamManagmentSystemRefactorization.service.auth.region.RegionAuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/region/auth")
public class RegionAuthController {
    private final RegionAuthService regionAuthService;
    @PostMapping("login")
    public ResponseEntity<GeneralSuccessResponseDto<Object>> loginRegion(@Valid @RequestBody RegionLoginRequestDto regionLoginRequestDto, HttpServletResponse response){
        return ResponseEntity
                .ok()
                .body(GeneralSuccessResponseDto
                        .<Object>builder()
                        .message(regionAuthService.loginRegion(regionLoginRequestDto, response))
                        .data(null)
                        .build());
    }
}
