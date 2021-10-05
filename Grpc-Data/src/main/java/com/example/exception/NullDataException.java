package com.example.exception;

public class NullDataException extends Exception{
    NullDataException(String errorMessage){
        super(errorMessage);
    }
    //다른 여러가지 로직 삽입가능
}
