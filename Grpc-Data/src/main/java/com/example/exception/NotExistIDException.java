package com.example.exception;

public class NotExistIDException extends Exception{
    public NotExistIDException() {
        super("사용자가 존재하지 않는 번호를 입력했습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
