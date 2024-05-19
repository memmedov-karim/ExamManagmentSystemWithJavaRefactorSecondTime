package com.example.ExamManagmentSystemRefactorization.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String father;
    @Column(nullable = false)
    private String clas;
    @Column(nullable = false)
    private String sector;
    private String fenn;
    private String room;
    private String place;
    private String phone;
    private String utis;
    @ManyToOne
    @JoinColumn(name="region_id",nullable = false)
    private Region region;
    @ManyToOne
    @JoinColumn(name = "exam_id",nullable = false)
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "center_id",nullable = false)
    private Center center;

}
