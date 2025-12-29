package com.school.appointsystem.exception;

// 预约记录不存在异常
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
