package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;

public class StringMethods {
    private static final String SEPARATOR = SCRSProperties.SEPARATOR;
    private static final String EMPTY = SCRSProperties.EMPTY;
    private CheckAlreadyMethods check;

    public StringMethods() {
        check = new CheckAlreadyMethods();
    }

    public String makeCourseInfoString(Course course) throws NotEnoughDataException {
        String id = course.getId();
        String name = course.getName();
        String profName = course.getProfName();
        isNull(id, name, profName);
        return id+SEPARATOR+name+SEPARATOR+profName+SEPARATOR+makePreCourseStr(course.getPreCoursesList());
    }

    public String makeStudentInfoString(Student request) throws NotEnoughDataException {
        String id = request.getId();
        String name = request.getName();
        String major = request.getMajor();
        isNull(id, name, major);
        return id+SEPARATOR+name+SEPARATOR+major;
    }

    public String makePreCourseStr(ProtocolStringList list){
        String splitStr = EMPTY;
        for (String s : list) splitStr += s + SEPARATOR;
        return splitStr;
    }

    public void getMenuList(StreamObserver<MenuResponse> responseObserver) {
        responseObserver.onNext(MenuResponse.newBuilder()
                .addMenuList(SCRSProperties.WELCOME_MESSAGE)
                .addMenuList(SCRSProperties.MENU1)
                .addMenuList(SCRSProperties.MENU2)
                .addMenuList(SCRSProperties.MENU3)
                .addMenuList(SCRSProperties.MENU4)
                .addMenuList(SCRSProperties.MENU5)
                .addMenuList(SCRSProperties.MENU6)
                .addMenuList(SCRSProperties.MENU7)
                .addMenuList(SCRSProperties.MENU8)
                .build());
    }

    public void isNull(String  data1, String  data2, String  data3) throws NotEnoughDataException {
        nullOrEmpty(data1);
        nullOrEmpty(data2);
        nullOrEmpty(data3);
    }

    public void nullOrEmpty(String data) throws NotEnoughDataException {
        if(data == null || data.equals(EMPTY)) throw new NotEnoughDataException();
    }

    public String makeDataString(ListDataResponse listData) {
        String retVal= "";
        for (String listDatum : listData.getDataList()) retVal+=listDatum+"\n";
        return retVal;
    }

    public String makeSeparatorString(String data1, String data2){
        return data1 + SCRSProperties.SEPARATOR + data2;
    }
}
