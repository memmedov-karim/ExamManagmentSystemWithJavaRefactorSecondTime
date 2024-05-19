package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.dto.GeneralSuccessResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userlogin.UserLoginRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userlogin.UserLoginResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userlogout.UserLogoutResponse;
import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterRequestDto;
import com.example.ExamManagmentSystemRefactorization.service.auth.user.UserAuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/auth")
public class UserAuthController {
    private final UserAuthService userAuthService;
    @PostMapping("login")
    public ResponseEntity<GeneralSuccessResponseDto<String>> loginUser(@RequestBody @Valid UserLoginRequestDto userLoginRequestDto, HttpServletResponse response){
        return ResponseEntity.ok().body(GeneralSuccessResponseDto.<String>builder()
                .message(userAuthService.loginUser(userLoginRequestDto,response))
                .data(null).
                build()
        );
    }
    @GetMapping("logout")
    public ResponseEntity<GeneralSuccessResponseDto<String>> logoutUser(HttpServletRequest request,HttpServletResponse response){
        return ResponseEntity.ok().body(GeneralSuccessResponseDto.<String>builder()
                .message(userAuthService.logoutUser(request,response))
                .data(null).build()
        );
    }
    @PostMapping("register")
    public ResponseEntity<GeneralSuccessResponseDto<String>> registerNewUser(@RequestBody @Valid UserRegisterRequestDto userRegisterRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(GeneralSuccessResponseDto.<String>builder()
                .message(userAuthService.registerNewUser(userRegisterRequestDto))
                .data(null)
                .build()
        );
    }
}
