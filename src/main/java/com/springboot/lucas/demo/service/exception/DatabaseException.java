package com.springboot.lucas.demo.service.exception;

public class DatabaseException extends RuntimeException {//caso de outro erro n tratado, eu lanço esse;
    public static final long serialVersionUID = 1L;

    public DatabaseException(String msg){
        super(msg);
    }
}