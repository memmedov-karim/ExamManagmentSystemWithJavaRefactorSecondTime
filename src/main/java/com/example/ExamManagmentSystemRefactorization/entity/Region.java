package com.example.ExamManagmentSystemRefactorization.entity;

import com.example.ExamManagmentSystemRefactorization.util.common.PasswordGenerator;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Region extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @PrePersist
    public void generatePassword() {
        this.password = PasswordGenerator.generateRandomPassword(8);
    }
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @OneToMany(mappedBy = "region",fetch = FetchType.LAZY)
    private List<Center> centers;
    @OneToMany(mappedBy = "region",fetch = FetchType.LAZY)
    private List<Ticket> tickets;

}
