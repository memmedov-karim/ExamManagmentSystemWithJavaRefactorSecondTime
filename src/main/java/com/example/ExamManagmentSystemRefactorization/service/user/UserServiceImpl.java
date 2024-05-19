package com.example.ExamManagmentSystemRefactorization.service.user;

import com.example.ExamManagmentSystemRefactorization.dto.GeneralSuccessResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.userregion.RegionForUserDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.UserNotFoundException;
import com.example.ExamManagmentSystemRefactorization.mapper.RegionMapper;
import com.example.ExamManagmentSystemRefactorization.repository.UserRepository;
import com.example.ExamManagmentSystemRefactorization.util.user.UserResourceChecker;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;
    private final UserResourceChecker userResourceChecker;
    private final RegionMapper regionMapper;


    @Override
    public User findUserById(Long userid){
        Optional<User> optionalUser = userRepository.findById(userid);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException();
        }
        return optionalUser.get();
    }

}
