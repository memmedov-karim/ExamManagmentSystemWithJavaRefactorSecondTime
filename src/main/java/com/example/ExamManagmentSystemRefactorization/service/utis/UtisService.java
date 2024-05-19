package com.example.ExamManagmentSystemRefactorization.service.utis;

import com.example.ExamManagmentSystemRefactorization.entity.Region;

public interface UtisService {

    String generateUniqueUtis(Region region, int n);

}
