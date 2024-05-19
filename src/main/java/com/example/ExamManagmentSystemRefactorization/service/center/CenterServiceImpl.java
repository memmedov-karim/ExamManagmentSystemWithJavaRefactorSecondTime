package com.example.ExamManagmentSystemRefactorization.service.center;

import com.example.ExamManagmentSystemRefactorization.dto.center.newcenter.NewCenterRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.center.newcenter.NewCenterResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.center.regioncenter.CenterForRegionDto;
import com.example.ExamManagmentSystemRefactorization.entity.Center;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.exception.CenterNotFoundException;
import com.example.ExamManagmentSystemRefactorization.mapper.CenterMapper;
import com.example.ExamManagmentSystemRefactorization.repository.CenterRepository;
import com.example.ExamManagmentSystemRefactorization.service.region.RegionService;
import com.example.ExamManagmentSystemRefactorization.util.center.CenterResourcesChecker;
import com.example.ExamManagmentSystemRefactorization.util.region.RegionResourceChecker;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CenterServiceImpl implements CenterService{
    private final CenterRepository centerRepository;
    private final CenterResourcesChecker centerResourcesChecker;
    private final RegionService regionService;
    private final RegionResourceChecker regionResourceChecker;
    private final CenterMapper centerMapper;
    @Override
    public NewCenterResponseDto addNewCenter(Long regionid,NewCenterRequestDto newCenterRequestDto){
        Region existingRegion = regionService.findRegionById(regionid);
        regionResourceChecker.ifRegionDoesnotExistThrowException(existingRegion);
        Center exsitingCenter = findexistingcenterByName(existingRegion.getCenters(), newCenterRequestDto.getName());
        centerResourcesChecker.throwExceptionIfCenterAlreadyExist(exsitingCenter);
        Center newCenterInstance = new Center();
        newCenterInstance.setName(newCenterRequestDto.getName());
        newCenterInstance.setCity(newCenterRequestDto.getCity());
        newCenterInstance.setCode(newCenterRequestDto.getCode());
        newCenterInstance.setRegion(existingRegion);
        Center savedCenter = centerRepository.save(newCenterInstance);
        return NewCenterResponseDto
                .builder()
                .id(savedCenter.getId())
                .name(savedCenter.getName())
                .city(savedCenter.getCity())
                .code(savedCenter.getCode())
                .build();
    }
    @Override
    public List<CenterForRegionDto> getListOfCenterForRegion(Long regionid){
        Region existingRegion = regionService.findRegionById(regionid);
        regionResourceChecker.ifRegionDoesnotExistThrowException(existingRegion);
        return centerMapper.mapToListOfCenterForRegionDto(existingRegion.getCenters());
    }
    @Override
    public Center findexistingcenterByName(List<Center> centers, String name){
        for (Center center : centers) {
            if (center.getName().equals(name)) {
                return center;
            }
        }
        return null;
    }

    @Override
    public Center findCenterById(Long centerid){
        Optional<Center> optionalCenter = centerRepository.findById(centerid);
        if(optionalCenter.isEmpty()){
            throw new CenterNotFoundException();
        }
        return optionalCenter.get();
    }

}
