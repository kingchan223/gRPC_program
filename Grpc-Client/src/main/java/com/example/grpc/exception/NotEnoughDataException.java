package com.example.grpc.exception;

public class NotEnoughDataException extends Exception{

    public NotEnoughDataException() {
        super("데이터가 충분하지 않습니다❗️❗️❗");
    }
}
