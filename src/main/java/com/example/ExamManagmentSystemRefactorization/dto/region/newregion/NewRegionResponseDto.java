package com.example.ExamManagmentSystemRefactorization.dto.region.newregion;

import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;
@Getter
@Setter
public class NewRegionResponseDto {
    private String username;
    private String password;
    private String createdAt;
}
