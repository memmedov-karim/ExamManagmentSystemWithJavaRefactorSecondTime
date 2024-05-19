package com.example.ExamManagmentSystemRefactorization.util.center;
import com.example.ExamManagmentSystemRefactorization.entity.Center;
import com.example.ExamManagmentSystemRefactorization.exception.CenterAlreadyExistException;
import com.example.ExamManagmentSystemRefactorization.exception.CenterNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CenterResourcesChecker {
    public void throwExceptionIfCenterDoesnotExist(Center center){
        if(center==null){
            throw new CenterNotFoundException();
        }
    }
    public void throwExceptionIfCenterAlreadyExist(Center center){
        if(center!=null){
            throw new CenterAlreadyExistException(center.getName());
        }
    }

}
