package com.example.exception;

public class AlreadyExistStudentIDException extends Exception{

    public AlreadyExistStudentIDException() {
        super("사용자가 이미 존재하는 학생번호를 추가하는 시도했습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
