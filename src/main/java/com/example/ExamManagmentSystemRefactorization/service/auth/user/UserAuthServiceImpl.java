package com.example.ExamManagmentSystemRefactorization.service.auth.user;

import com.example.ExamManagmentSystemRefactorization.dto.user.userlogin.UserLoginRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterRequestDto;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.repository.UserRepository;
import com.example.ExamManagmentSystemRefactorization.service.auth.jwt.JwtService;
import com.example.ExamManagmentSystemRefactorization.service.user.UserService;
import com.example.ExamManagmentSystemRefactorization.util.user.UserResourceChecker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final UserResourceChecker userResourceChecker;
    private final JwtService jwtService;
    @Override
    public String registerNewUser(UserRegisterRequestDto userRegisterRequestDto){
        String email = userRegisterRequestDto.getEmail();
        User existingUser = userService.findByEmail(email);
        User newUserInstance = new User();
        newUserInstance.setName(userRegisterRequestDto.getName());
        newUserInstance.setEmail(email);
        newUserInstance.setPassword(userRegisterRequestDto.getPassword());
        userRepository.save(newUserInstance);
        return "Success register";
    }
    @Override
    public String  loginUser(UserLoginRequestDto userLoginRequestDto, HttpServletResponse response){
        String email = userLoginRequestDto.getEmail();
        User existingUser = userService.findByEmail(email);
        String password = userLoginRequestDto.getPassword();
        userResourceChecker.isUserPasswordIsNotCorrectThrowException(password, existingUser.getPassword());
        jwtService.sendTokenWithCookie(existingUser.getId(),"tokenU",response);
        return "Success login";
    }

    @Override
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        jwtService.clearCookie(request,response,"tokenU");
        return "Success logout";
    }
}
