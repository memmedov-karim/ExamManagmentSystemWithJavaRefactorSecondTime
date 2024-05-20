package com.example.ExamManagmentSystemRefactorization.service.user;

import com.example.ExamManagmentSystemRefactorization.dto.GeneralSuccessResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.userregion.RegionForUserDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {


    User findUserById(Long userid);
    User findByEmail(String email);
}
