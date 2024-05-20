package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.annotation.TokenParam;
import com.example.ExamManagmentSystemRefactorization.constant.ConstantVariable;
import com.example.ExamManagmentSystemRefactorization.dto.exam.newexam.NewExamRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.exam.newexam.NewExamResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.exam.userexam.ExamForUserDto;
import com.example.ExamManagmentSystemRefactorization.entity.Exam;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.service.exam.ExamService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exams")
public class ExamController {
    private final ExamService examService;
    @PostMapping("creat")
    public ResponseEntity<NewExamResponseDto> creatNewExam(@TokenParam(ConstantVariable.TokenNames.USERTOKENNAME) Long userid,
                                                           @RequestBody @Valid NewExamRequestDto newExamRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(examService.createNewExam(userid,newExamRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<ExamForUserDto>> getListOfExamsForUser(@TokenParam(ConstantVariable.TokenNames.USERTOKENNAME) Long userid){
        return ResponseEntity.ok().body(examService.getListOfExamsForUser(userid));
    }
}
