package com.school.appointsystem.exception;

// 学号已存在异常
public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
