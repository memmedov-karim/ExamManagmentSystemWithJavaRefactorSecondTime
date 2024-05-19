package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.annotation.TokenParam;
import com.example.ExamManagmentSystemRefactorization.dto.GeneralSuccessResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.userregion.RegionForUserDto;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.service.region.RegionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/regions")
public class RegionController {
    private final RegionService regionService;
    @GetMapping
    public ResponseEntity<List<RegionForUserDto>> getListOfRegionsForUser(@TokenParam("tokenU") Long userid){
        return ResponseEntity.ok().body(regionService.getListOfRegionForUser(userid));
    }
    @PostMapping("/creat")
    public ResponseEntity<NewRegionResponseDto> registerRegion(@TokenParam("tokenU") Long userid, @Valid @RequestBody NewRegionRequestDto newRegionRequestDto){
        System.out.println("Controller is work");
        return ResponseEntity.status(HttpStatus.CREATED).body(regionService.registerRegion(userid, newRegionRequestDto));
    }
}
