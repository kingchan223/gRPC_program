package com.example.grpc.exception;

public class AlreadyTakeCourseIDException extends Exception{

    public AlreadyTakeCourseIDException() {
        super("사용자가 이미 수강한 강좌의 강좌번호로 수강신청을 시도했습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
