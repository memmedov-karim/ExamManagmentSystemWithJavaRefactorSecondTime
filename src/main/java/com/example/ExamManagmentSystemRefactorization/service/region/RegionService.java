package com.example.ExamManagmentSystemRefactorization.service.region;

import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.userregion.RegionForUserDto;
import com.example.ExamManagmentSystemRefactorization.entity.Region;

import com.example.ExamManagmentSystemRefactorization.entity.User;
import java.util.List;

public interface RegionService {
    NewRegionResponseDto registerRegion(Long userid, NewRegionRequestDto newRegionRequestDto);
    List<RegionForUserDto> getListOfRegionForUser(Long userid);
    Region findRegionById(Long regionid);
    Region findByUsername(String username);
}
