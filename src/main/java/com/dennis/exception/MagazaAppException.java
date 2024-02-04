package com.dennis.exception;

import lombok.Getter;

@Getter
public class MagazaAppException extends RuntimeException{

    private final ErrorType errorType;
    public MagazaAppException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MagazaAppException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
