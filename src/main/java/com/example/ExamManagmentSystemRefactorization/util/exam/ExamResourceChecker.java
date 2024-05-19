package com.example.ExamManagmentSystemRefactorization.util.exam;

import com.example.ExamManagmentSystemRefactorization.entity.Exam;
import com.example.ExamManagmentSystemRefactorization.exception.*;
import org.springframework.stereotype.Component;

@Component
public class ExamResourceChecker {
    public void ifExamDoesnotExistThrowException(Exam exam){
        if(exam==null){
            throw new ExamNotFoundException();
        }
    }
    public void ifExamAlreadyExistThrowException(Exam exam){
        if(exam!=null){
            throw new ExamAlreadyExistException(exam.getName());
        }
    }
}
