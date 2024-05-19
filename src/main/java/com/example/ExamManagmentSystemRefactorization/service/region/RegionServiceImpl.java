package com.example.ExamManagmentSystemRefactorization.service.region;

import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.userregion.RegionForUserDto;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.RegionNotFoundException;
import com.example.ExamManagmentSystemRefactorization.exception.UserNotFoundException;
import com.example.ExamManagmentSystemRefactorization.mapper.RegionMapper;
import com.example.ExamManagmentSystemRefactorization.repository.RegionRepository;
import com.example.ExamManagmentSystemRefactorization.repository.UserRepository;
import com.example.ExamManagmentSystemRefactorization.service.user.UserService;
import com.example.ExamManagmentSystemRefactorization.util.region.RegionResourceChecker;
import com.example.ExamManagmentSystemRefactorization.util.user.UserResourceChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService{
    private final RegionRepository regionRepository;
    private final UserResourceChecker userResourceChecker; 
    private final RegionResourceChecker regionResourceChecker;
    private final RegionMapper regionMapper;
    private final UserService userService;
    @Override
    public NewRegionResponseDto registerRegion(Long userid, NewRegionRequestDto newRegionRequestDto){
        User user = userService.findUserById(userid);
        String username = newRegionRequestDto.getUsername();
        Region existingRegion = regionRepository.findByUsernameAndUser(username,user);
        regionResourceChecker.ifRegionAlreadyExistThrowException(existingRegion);
        Region newRegionInstance = new Region();
        newRegionInstance.setUsername(username);
        newRegionInstance.setUser(user);
        Region savedRegion = regionRepository.save(newRegionInstance);
        NewRegionResponseDto nrrd = new NewRegionResponseDto();
        nrrd.setUsername(savedRegion.getUsername());
        nrrd.setPassword(savedRegion.getPassword());
        nrrd.setCreatedAt(String.valueOf(savedRegion.getCreatedAt()));
        return nrrd;
    }

    @Override
    public Region findRegionById(Long regionid){
        Optional<Region> optionalRegion = regionRepository.findById(regionid);
        if(optionalRegion.isEmpty()){
            throw new RegionNotFoundException();
        }
        return optionalRegion.get();
    }
    @Override
    public List<RegionForUserDto> getListOfRegionForUser(Long userid){
        User user = userService.findUserById(userid);
        return regionMapper.mapToListOfRegionForUserDto(user.getRegions());
    }
    @Override
    public Region findByUsername(String username){
        Region existingRegion = regionRepository.findByUsername(username);
        regionResourceChecker.ifRegionDoesnotExistThrowException(existingRegion);
        return existingRegion;
    }

}
