package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.annotation.TokenParam;
import com.example.ExamManagmentSystemRefactorization.dto.GeneralSuccessResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.center.newcenter.NewCenterRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.center.newcenter.NewCenterResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.center.regioncenter.CenterForRegionDto;
import com.example.ExamManagmentSystemRefactorization.service.center.CenterService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/centers")
public class CenterController {
    private final CenterService centerService;

    @PostMapping("add")
    public ResponseEntity<GeneralSuccessResponseDto<NewCenterResponseDto>> addNewCenter(@TokenParam("tokenR") Long regionid, @Valid @RequestBody NewCenterRequestDto newCenterRequestDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GeneralSuccessResponseDto
                .<NewCenterResponseDto>builder()
                .message("Region added succesfully")
                .data(centerService.addNewCenter(regionid, newCenterRequestDto))
                .build()
        );
    }
    @GetMapping
    public ResponseEntity<GeneralSuccessResponseDto<List<CenterForRegionDto>>> getListOfCenterForRegion(@TokenParam("tokenR") Long regionid){
        return ResponseEntity
                .ok()
                .body(GeneralSuccessResponseDto
                        .<List<CenterForRegionDto>>builder()
                        .message("Centers fetched succesfully")
                        .data(centerService.getListOfCenterForRegion(regionid))
                        .build()
                );
    }
}
