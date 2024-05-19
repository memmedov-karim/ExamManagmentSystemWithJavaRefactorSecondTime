package com.example.ExamManagmentSystemRefactorization.mapper;

import com.example.ExamManagmentSystemRefactorization.dto.region.userregion.RegionForUserDto;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class RegionMapper {

    public RegionForUserDto mapToRegionForUserDto(Region region){
        RegionForUserDto rfud = new RegionForUserDto();
        rfud.setId(region.getId());
        rfud.setUsername(region.getUsername());
        rfud.setPassword(region.getPassword());
        rfud.setCreatedAt(String.valueOf(region.getCreatedAt()));
        rfud.setUpdatedAt(String.valueOf(region.getUpdatedAt()));
        return rfud;
    }

    public List<RegionForUserDto> mapToListOfRegionForUserDto(List<Region> regions){
        List<RegionForUserDto> r = regions.stream().map(this::mapToRegionForUserDto).toList();
        return r;
    }
}
