package com.example.exception;

public class AlreadyExistIdException extends Exception{
    public AlreadyExistIdException(String errorMessage){
        super("이미 존재하는 ID입니다.");
    }

    public AlreadyExistIdException() {
        super("이미 존재하는 ID입니다.");
    }
    //다른 여러가지 로직 삽입가능
}
