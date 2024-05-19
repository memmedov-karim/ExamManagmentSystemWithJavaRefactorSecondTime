package com.example.ExamManagmentSystemRefactorization.mapper;

import com.example.ExamManagmentSystemRefactorization.dto.exam.userexam.ExamForUserDto;
import com.example.ExamManagmentSystemRefactorization.entity.Exam;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {
    public ExamForUserDto mapToExamForUserDto(Exam exam){
        return ExamForUserDto.builder()
                .id(exam.getId())
                .name(exam.getName())
                .title(exam.getTitle())
                .dateandtime(exam.getDateandtime())
                .createdAt(exam.getCreatedAt())
                .build();
    }

    public List<ExamForUserDto> mapToListOfExamForUserDto(List<Exam> exams){
        return exams.stream().map(this::mapToExamForUserDto).toList();
    }

}
