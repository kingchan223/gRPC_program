package com.example.exception;

public class NullDataException extends Exception{
    public NullDataException() {
        super("사용자가 입력한 데이터가 충분하지 않습니다.");
    }
}
