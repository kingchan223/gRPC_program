package com.example.grpc.server;

import com.example.grpc.Course;
import com.example.grpc.MenuResponse;
import com.example.grpc.SCRSProperties;
import com.example.grpc.Student;
import com.example.grpc.exception.NotEnoughDataException;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;

public class StringMethods {
    private static final String SEPARATOR = SCRSProperties.SEPARATOR;
    private static final String EMPTY = SCRSProperties.EMPTY;

    public String extractCourseInfo(Course course) throws NotEnoughDataException {
        String id = course.getId();
        String name = course.getName();
        String profName = course.getProfName();
        isNull(id, name, profName);
        return id +SEPARATOR+ name +SEPARATOR+ profName +SEPARATOR+ makePreCourseStr(course.getPreCoursesList());
    }

    public String extractStudentInfo(Student request) throws NotEnoughDataException {
        String id = request.getId();
        String name = request.getName();
        String major = request.getMajor();
        isNull(id, name, major);
        return id +SEPARATOR+ name+SEPARATOR+ major+SEPARATOR;
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
                .addMenuList(SCRSProperties.MENU4)
                .addMenuList(SCRSProperties.MENU5)
                .addMenuList(SCRSProperties.MENU6)
                .addMenuList(SCRSProperties.MENU7)
                .addMenuList(SCRSProperties.MENU8)
                .build());
    }

    public void isNull(String  data1, String  data2, String  data3) throws NotEnoughDataException {
        if(nullOrEmpty(data1) || nullOrEmpty(data2)||nullOrEmpty(data3)) throw new NotEnoughDataException();
    }

    public boolean nullOrEmpty(String data){
        return data != null && !data.equals(EMPTY);
    }
}
