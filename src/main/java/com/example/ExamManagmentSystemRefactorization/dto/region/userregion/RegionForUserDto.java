package com.example.ExamManagmentSystemRefactorization.dto.region.userregion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionForUserDto {
    private Long id;
    private String username;
    private String password;
    private String createdAt;
    private String updatedAt;
}
