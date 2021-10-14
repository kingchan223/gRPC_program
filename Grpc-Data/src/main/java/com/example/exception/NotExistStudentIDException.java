package com.example.exception;

public class NotExistStudentIDException extends Exception{
    public NotExistStudentIDException() {
        super("사용자가 존재하지 않는 학생번호를 입력했습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
