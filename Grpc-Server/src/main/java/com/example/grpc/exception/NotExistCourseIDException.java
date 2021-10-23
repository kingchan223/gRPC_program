package com.example.grpc.exception;

public class NotExistCourseIDException extends Exception{
    public NotExistCourseIDException() {
        super("사용자가 존재하지 않는 강좌번호를 입력했습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
