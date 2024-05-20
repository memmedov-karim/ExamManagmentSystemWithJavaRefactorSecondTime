package com.example.ExamManagmentSystemRefactorization.util.region;

import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.*;
import org.springframework.stereotype.Component;

@Component
public class RegionResourceChecker {
    public void ThrowExceptionIfRegionDoesnotExist(Region region){
        if(region==null){
            throw new RegionNotFoundException();
        }
    }
    public void ThrowExceptionIfRegionAlreadyExist(Region region){
        if(region!=null){
            throw new RegionAlreadyExistException(region.getUsername());
        }
    }

    public void ThrowExceptionIfRegionPasswordIsNotCorrect(String regionloginpassword,String regionrealpassword){
        if(!regionloginpassword.equals(regionrealpassword)){
            throw  new PasswordIsNotCorrectException();
        }
    }
}
