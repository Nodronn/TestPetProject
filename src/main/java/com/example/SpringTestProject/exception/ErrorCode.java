package com.example.SpringTestProject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorCode {
    private String message;
    private int code;

    public static ErrorCode INVALID_EMAIL_OR_PASSWORD = new ErrorCode("Invalid email or password", 1);
    public static ErrorCode USER_NOT_FOUND = new ErrorCode("User not found", 2);
    public static ErrorCode USER_EXISTS_ALREADY = new ErrorCode("User exists already", 3);
}
