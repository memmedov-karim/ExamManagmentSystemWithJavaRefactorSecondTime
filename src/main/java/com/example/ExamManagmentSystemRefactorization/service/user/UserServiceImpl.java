package com.example.ExamManagmentSystemRefactorization.service.user;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.UserNotFoundException;
import com.example.ExamManagmentSystemRefactorization.repository.UserRepository;
import com.example.ExamManagmentSystemRefactorization.util.user.UserResourceChecker;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;
    private final UserResourceChecker userResourceChecker;

    @Override
    public User findUserById(Long userid){
        Optional<User> optionalUser = userRepository.findById(userid);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException();
        }
        return optionalUser.get();
    }
    @Override
    public User findByEmail(String email){
        User existingUser = userRepository.findByEmail(email);
        userResourceChecker.ifUserDoesnotExistThrowException(existingUser);
        return existingUser;
    }

}
