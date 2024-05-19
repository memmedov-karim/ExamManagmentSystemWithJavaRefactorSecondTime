package com.example.ExamManagmentSystemRefactorization.repository;

import com.example.ExamManagmentSystemRefactorization.entity.Center;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<Center,Long> {

    Center findCenterByNameAndRegion_Id(String name, Long regionid);
}
