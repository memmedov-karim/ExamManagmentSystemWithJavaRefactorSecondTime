package com.example.ExamManagmentSystemRefactorization.service.center;

import com.example.ExamManagmentSystemRefactorization.dto.center.newcenter.NewCenterRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.center.newcenter.NewCenterResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.center.regioncenter.CenterForRegionDto;
import com.example.ExamManagmentSystemRefactorization.entity.Center;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import java.util.List;

public interface CenterService {

    NewCenterResponseDto addNewCenter(Long regionid, NewCenterRequestDto newCenterRequestDto);

    Center findexistingcenterByName(List<Center> centers, String name);
    Center findCenterById(Long centerid);
    List<CenterForRegionDto> getListOfCenterForRegion(Long regionid);

}
