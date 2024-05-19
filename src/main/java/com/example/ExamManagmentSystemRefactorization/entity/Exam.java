package com.example.ExamManagmentSystemRefactorization.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Exam extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String dateandtime;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
