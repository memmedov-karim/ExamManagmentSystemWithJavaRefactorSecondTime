package com.example.ExamManagmentSystemRefactorization.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

@Getter
@Setter
@Entity
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Region> regions;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Exam> exams;
}
