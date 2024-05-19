package com.example.ExamManagmentSystemRefactorization.service.exam;

import com.example.ExamManagmentSystemRefactorization.dto.exam.newexam.NewExamRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.exam.newexam.NewExamResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.exam.userexam.ExamForUserDto;
import com.example.ExamManagmentSystemRefactorization.dto.region.newregion.NewRegionRequestDto;
import com.example.ExamManagmentSystemRefactorization.entity.Exam;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import java.util.List;

public interface ExamService {
    NewExamResponseDto createNewExam(Long userid, NewExamRequestDto newExamRequestDto);
    List<ExamForUserDto> getListOfExamsForUser(Long userid);

    Exam findExamById(Long examid);
}
