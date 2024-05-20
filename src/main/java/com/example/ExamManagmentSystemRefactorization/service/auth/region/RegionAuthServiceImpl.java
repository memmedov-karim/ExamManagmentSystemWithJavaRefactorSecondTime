package com.example.ExamManagmentSystemRefactorization.service.auth.region;

import com.example.ExamManagmentSystemRefactorization.dto.region.regionlogin.RegionLoginRequestDto;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.service.auth.jwt.JwtService;
import com.example.ExamManagmentSystemRefactorization.service.region.RegionService;
import com.example.ExamManagmentSystemRefactorization.util.region.RegionResourceChecker;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionAuthServiceImpl implements RegionAuthService{
    private final JwtService jwtService;
    private final RegionService regionService;
    private final RegionResourceChecker regionResourceChecker;

    @Override
    public String loginRegion(RegionLoginRequestDto regionLoginRequestDto, HttpServletResponse response){
        Region existingRegion = regionService.findByUsername(regionLoginRequestDto.getUsername());
        regionResourceChecker.ThrowExceptionIfRegionPasswordIsNotCorrect(regionLoginRequestDto.getPassword(), existingRegion.getPassword());
        jwtService.sendTokenWithCookie(existingRegion.getId(),"tokenR",response);
        return "Success login";

    }
}
