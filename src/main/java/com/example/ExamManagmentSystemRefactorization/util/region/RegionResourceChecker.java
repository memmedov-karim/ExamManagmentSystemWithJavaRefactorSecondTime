package com.example.ExamManagmentSystemRefactorization.util.region;

import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.*;
import org.springframework.stereotype.Component;

@Component
public class RegionResourceChecker {
    public void ifRegionDoesnotExistThrowException(Region region){
        if(region==null){
            throw new RegionNotFoundException();
        }
    }
    public void ifRegionAlreadyExistThrowException(Region region){
        if(region!=null){
            throw new RegionAlreadyExistException(region.getUsername());
        }
    }

    public void isRegionPasswordIsNotCorrectThrowException(String regionloginpassword,String regionrealpassword){
        if(!regionloginpassword.equals(regionrealpassword)){
            throw  new PasswordIsNotCorrectException();
        }
    }
}
