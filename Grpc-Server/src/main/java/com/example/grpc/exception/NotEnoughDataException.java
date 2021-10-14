package com.example.grpc.exception;

public class NotEnoughDataException extends Exception{

    public NotEnoughDataException() {
        super("사용자에게 받은 데이터가 충분하지 않습니다.");
    }
    //다른 여러가지 로직 삽입가능
}
