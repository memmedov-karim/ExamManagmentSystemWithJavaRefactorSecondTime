package com.example.ExamManagmentSystemRefactorization.controller;

import com.example.ExamManagmentSystemRefactorization.dto.user.userregister.UserRegisterRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {
    @RequestMapping
    public String test(){
        return "ok!";
    }
    @PostMapping
    public String testr(@RequestBody @Valid UserRegisterRequestDto userRegisterRequestDto){
        return "created";
    }
}
