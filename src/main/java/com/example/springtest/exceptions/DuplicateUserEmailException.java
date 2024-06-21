package com.example.springtest.exceptions;

public class DuplicateUserEmailException extends RuntimeException{

    public DuplicateUserEmailException(String msg) {
        super(msg);
    }
}
