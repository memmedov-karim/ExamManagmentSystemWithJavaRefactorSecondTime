package com.example.ExamManagmentSystemRefactorization.repository;

import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    Region findByUsernameAndUser(String username, User user);
    List<Region> findByUser_Id(Long userid);
    Region findByUsername(String username);
}
