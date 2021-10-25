package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;

public class StringMethods {
    private static final String SEPARATOR = ServerProps.SEPARATOR;
    private static final String EMPTY = ServerProps.EMPTY;

    public String makeCourseInfoString(Course course){
        String id = course.getId();
        String name = course.getName();
        String profName = course.getProfName();
//        isNull(id, name, profName);
        return id+SEPARATOR+name+SEPARATOR+profName+SEPARATOR+makePreCourseStr(course.getPreCoursesList());
    }

    public String makeStudentInfoString(Student request){
        String id = request.getId();
        String name = request.getName();
        String major = request.getMajor();
//        isNull(id, name, major);
        return id+SEPARATOR+name+SEPARATOR+major;
    }

    public String makePreCourseStr(ProtocolStringList list){
        String splitStr = EMPTY;
        for (String s : list) splitStr += s + SEPARATOR;
        return splitStr;
    }

    public void getMenuList(StreamObserver<MenuResponse> responseObserver) {
        responseObserver.onNext(MenuResponse.newBuilder()
                .addMenuList(ServerProps.WELCOME_MESSAGE)
                .addMenuList(ServerProps.MENU1)
                .addMenuList(ServerProps.MENU2)
                .addMenuList(ServerProps.MENU3)
                .addMenuList(ServerProps.MENU4)
                .addMenuList(ServerProps.MENU5)
                .addMenuList(ServerProps.MENU6)
                .addMenuList(ServerProps.MENU7)
                .addMenuList(ServerProps.MENU8)
                .build());
    }

//    public void isNull(String  data1, String  data2, String  data3) throws NotEnoughDataException {
//        nullOrEmpty(data1);
//        nullOrEmpty(data2);
//        nullOrEmpty(data3);
//    }

    public void nullOrEmpty(String data) throws NotEnoughDataException {
        if(data == null || data.equals(EMPTY)) throw new NotEnoughDataException();
    }

    public String makeDataString(ListDataResponse listData) {
        String retVal= ServerProps.EMPTY;
        for (String listDatum : listData.getDataList()) retVal+=listDatum+ ServerProps.C13;
        return retVal;
    }

    public String makeSeparatorString(String data1, String data2){
        return data1 + ServerProps.SEPARATOR + data2;
    }
}
