package com.example.ExamManagmentSystemRefactorization.exception.handler;

import com.example.ExamManagmentSystemRefactorization.dto.error.ErrorGeneralResponse;
import com.example.ExamManagmentSystemRefactorization.exception.CookieNotFoundException;
import com.example.ExamManagmentSystemRefactorization.exception.TokenNotFoundException;
import com.example.ExamManagmentSystemRefactorization.exception.base.AlreadyExsistException;
import com.example.ExamManagmentSystemRefactorization.exception.base.FileGenerationException;
import com.example.ExamManagmentSystemRefactorization.exception.base.IsNotCorrectException;
import com.example.ExamManagmentSystemRefactorization.exception.base.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultErrorAttributes {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorGeneralResponse> handleNotFoundException(NotFoundException ex){
        ErrorGeneralResponse egr = new ErrorGeneralResponse();
        egr.setMessage(ex.getMessage());
        boolean checker = (ex instanceof CookieNotFoundException || ex instanceof TokenNotFoundException);
        HttpStatus status = checker ? HttpStatus.UNAUTHORIZED: HttpStatus.NOT_FOUND;
        egr.setStatus(status.value());
        egr.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(status).body(egr);
    }
    @ExceptionHandler(IsNotCorrectException.class)
    public ResponseEntity<ErrorGeneralResponse> handleIsNotCorrectException(IsNotCorrectException ex){
        ErrorGeneralResponse egr = new ErrorGeneralResponse();
        egr.setMessage(ex.getMessage());
        egr.setStatus(HttpStatus.BAD_REQUEST.value());
        egr.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(egr);
    }
    @ExceptionHandler(AlreadyExsistException.class)
    public ResponseEntity<ErrorGeneralResponse> handleAlreadyExistException(AlreadyExsistException ex){
        ErrorGeneralResponse egr = new ErrorGeneralResponse();
        egr.setMessage(ex.getMessage());
        egr.setStatus(HttpStatus.BAD_REQUEST.value());
        egr.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(egr);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorGeneralResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorGeneralResponse egr = new ErrorGeneralResponse();
        egr.setMessage(message);
        egr.setStatus(HttpStatus.BAD_REQUEST.value());
        egr.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(egr);
    }
    @ExceptionHandler(FileGenerationException.class)
    public ResponseEntity<ErrorGeneralResponse> handleFileGenerationException(FileGenerationException ex) {
        ErrorGeneralResponse egr = new ErrorGeneralResponse();
        egr.setMessage(ex.getMessage());
        egr.setStatus(HttpStatus.BAD_REQUEST.value());
        egr.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(egr);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorGeneralResponse> handleOtherPosibleException(Exception ex){
        ErrorGeneralResponse egr = new ErrorGeneralResponse();
        egr.setMessage(ex.getMessage());
        egr.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        egr.setTimestamp(LocalDateTime.now());
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(egr);
    }
}
