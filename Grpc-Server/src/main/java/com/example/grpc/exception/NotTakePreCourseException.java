package com.example.grpc.exception;

public class NotTakePreCourseException extends Exception{
    public NotTakePreCourseException() {
        super("사용자가 수강신청하려는 강좌의 선수강좌를 수강하지 않았습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
