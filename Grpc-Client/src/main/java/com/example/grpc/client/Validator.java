package com.example.grpc.client;

import com.example.grpc.exception.NotEnoughDataException;

public class Validator {
    public void isNull(String  data1, String  data2, String  data3) throws NotEnoughDataException {
        nullOrEmpty(data1);
        nullOrEmpty(data2);
        nullOrEmpty(data3);
    }

    public void isNull(String  data) throws NotEnoughDataException {
        nullOrEmpty(data);
    }

    public void nullOrEmpty(String data) throws NotEnoughDataException {
        if(data == null || data.equals(ClientProps.EMPTY)) throw new NotEnoughDataException();
    }

}
