package com.example.grpc.exception;

public class AlreadyExistCourseIDException extends Exception{
    public AlreadyExistCourseIDException() {
        super("사용자가 이미 존재하는 강좌번호를 추가하는 시도했습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
