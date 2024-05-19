package com.example.ExamManagmentSystemRefactorization.dto.exam.userexam;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExamForUserDto {
    private Long id;
    private String name;
    private String title;
    private String dateandtime;
    private Date createdAt;
}
