package com.example.ExamManagmentSystemRefactorization.util.user;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.PasswordIsNotCorrectException;
import com.example.ExamManagmentSystemRefactorization.exception.UserAlreadyExistException;
import com.example.ExamManagmentSystemRefactorization.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserResourceChecker {
    public void ifUserDoesnotExistThrowException(User user){
        if(user==null){
            throw new UserNotFoundException();
        }
    }
    public void ifUserAlreadyExistThrowException(User user){
        if(user!=null){
            throw new UserAlreadyExistException();
        }
    }

    public void isUserPasswordIsNotCorrectThrowException(String userloginpassword,String userrealpassword){
        if(!userloginpassword.equals(userrealpassword)){
            throw  new PasswordIsNotCorrectException();
        }
    }
}
