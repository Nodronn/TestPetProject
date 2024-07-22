package com.example.SpringTestProject.exception;

public class ClientException extends Exception {
    public ErrorCode clientErrorCode;

    public ClientException(ErrorCode clientErrorCode) {
        this.clientErrorCode = clientErrorCode;
    }
}
