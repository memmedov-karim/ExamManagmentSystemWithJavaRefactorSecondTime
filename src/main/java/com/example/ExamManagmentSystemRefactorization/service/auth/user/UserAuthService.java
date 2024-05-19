package com.example.ExamManagmentSystemRefactorization.service.auth.user;

import com.example.ExamManagmentSystemRefactorization.dto.GeneralSuccessResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userlogin.UserLoginRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userlogin.UserLoginResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userlogout.UserLogoutResponse;
import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserAuthService {
    String registerNewUser(UserRegisterRequestDto userRegisterRequestDto);
    String loginUser(UserLoginRequestDto userLoginRequestDto, HttpServletResponse response);
    String logoutUser(HttpServletRequest request, HttpServletResponse response);
}
