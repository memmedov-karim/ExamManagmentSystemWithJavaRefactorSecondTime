package com.example.ExamManagmentSystemRefactorization.service.exam;

import com.example.ExamManagmentSystemRefactorization.dto.exam.newexam.NewExamRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.exam.newexam.NewExamResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.exam.userexam.ExamForUserDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionRequestDto;
import com.example.ExamManagmentSystemRefactorization.entity.Exam;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.ExamNotFoundException;
import com.example.ExamManagmentSystemRefactorization.mapper.ExamMapper;
import com.example.ExamManagmentSystemRefactorization.repository.ExamRepository;
import com.example.ExamManagmentSystemRefactorization.repository.UserRepository;
import com.example.ExamManagmentSystemRefactorization.service.user.UserService;
import com.example.ExamManagmentSystemRefactorization.util.exam.ExamResourceChecker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService{
    private final ExamRepository examRepository;
    private final UserService userService;
    private final ExamResourceChecker examResourceChecker;
    private final ExamMapper examMapper;
    @Override
    public NewExamResponseDto createNewExam(Long userid, NewExamRequestDto newExamRequestDto){
        User user = userService.findUserById(userid);
        String name = newExamRequestDto.getName();
        Exam exsitingExam = examRepository.findByNameAndUser_Id(name, user.getId());
        examResourceChecker.ifExamAlreadyExistThrowException(exsitingExam);
        Exam newExamInstance = new Exam();
        newExamInstance.setName(newExamRequestDto.getName());
        newExamInstance.setTitle(newExamRequestDto.getTitle());
        newExamInstance.setDateandtime(newExamRequestDto.getDateandtime());
        newExamInstance.setUser(user);
        Exam savedExam = examRepository.save(newExamInstance);
        NewExamResponseDto nerd = new NewExamResponseDto();
        nerd.setName(savedExam.getName());
        nerd.setTitle(savedExam.getTitle());
        nerd.setDatandtime(savedExam.getDateandtime());
        nerd.setCreatedAt(String.valueOf(savedExam.getCreatedAt()));
        nerd.setUpdatedAt(String.valueOf(savedExam.getUpdatedAt()));
        return nerd;
    }

    @Override
    public List<ExamForUserDto> getListOfExamsForUser(Long userid){
        User user = userService.findUserById(userid);
        return examMapper.mapToListOfExamForUserDto(user.getExams());
    }

    @Override
    public Exam findExamById(Long examid){
        Optional<Exam> optionalExam = examRepository.findById(examid);
        if(optionalExam.isEmpty()){
            throw new ExamNotFoundException();
        }
        return optionalExam.get();
    }

}
