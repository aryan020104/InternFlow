package com.internflow.internflow_backend.exception;

public class UnauthorizedRoleException extends RuntimeException {

    public UnauthorizedRoleException(String message) {
        super(message);
    }
}