package com.example.grpc.client;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import com.google.protobuf.ProtocolStringList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SCRegisterConsoleManager {

    private final Validator validator;
    private final StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub;


    public SCRegisterConsoleManager() {
        this.validator = new Validator();
        stub = ServerConnection.connect();
    }

    public void getMenu() {
        MenuResponse response = stub.getMenu(MenuRequest.newBuilder().build());
        for (String menu : response.getMenuListList()) System.out.println(menu);
    }

    public void printListData(int n){
        if(n==1){
            ListDataResponse students = stub.getListData(ListDataRequest.newBuilder().setStudentOrCourse(SCode.STUDENT).build());
            for (String student : students.getDataList()) System.out.println(student);
        }
         else if(n==2){
            ProtocolStringList courses = stub.getListData(ListDataRequest.newBuilder().setStudentOrCourse(SCode.COURSE).build()).getDataList();
            for (String course : courses) System.out.println(course);
        }
    }

    public void putCourse() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProps.INPUT_ID_MSG);
        String id = br.readLine().trim();
        System.out.print(ClientProps.INPUT_COURSENAME_MSG);
        String name = br.readLine().trim();
        System.out.print(ClientProps.INPUT_PROFNAME_MSG);
        String profName = br.readLine().trim();
        System.out.print(ClientProps.INPUT_PRECOURSE_MSG);
        String[] preCourseStr = br.readLine().trim().split(ClientProps.SEPARATOR2);
        try {
            validator.isNull(id, name, profName);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProps.NULL_DATA_INPUT_AGAIN);
            return;
        }
        List<String> preCourses = new ArrayList<>(Arrays.asList(preCourseStr));
        printResult(stub.putCourse(Course.newBuilder().setId(id).setName(name).setProfName(profName).addAllPreCourses(preCourses).build()));
    }

    public void putStudent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProps.INPUT_ID_MSG);
        String id = br.readLine().trim();
        System.out.print(ClientProps.INPUT_NAME_MSG);
        String name = br.readLine().trim();
        System.out.print(ClientProps.INPUT_MAJOR_MSG);
        String major = br.readLine().trim();
        try {
            validator.isNull(id, name, major);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProps.NULL_DATA_INPUT_AGAIN);
            return;
        }
        printResult(stub.putStudent(Student.newBuilder().setId(id).setName(name).setMajor(major).build()));
    }

    public void deleteStudent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProps.STUDENT_DELETE_MESSAGE);
        String id = br.readLine().trim();
        try {
            validator.isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProps.INPUT_STUDENT_NUM_AGAIN);
            return;
        }
        printResult(stub.deleteStudentById(StudentId.newBuilder().setStudentId(id).build()));
    }

    public void deleteCourse() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProps.COURSE_DELETE_MESSAGE);
        String id = br.readLine().trim();
        try {
            validator.isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProps.INPUT_COURSE_NUM_AGAIN);
            return;
        }
        printResult(stub.deleteCourseById(CourseId.newBuilder().setCourseId(id).build()));
    }

    public void updateStudentByAddCourse() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProps.REGISTER_COURSE_STDID);
        String studentId = br.readLine().trim();
        System.out.print(ClientProps.REGISTER_COURSE_COURSEID);
        String courseId = br.readLine().trim();
        try {
            validator.isNull(studentId);
            validator.isNull(courseId);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProps.NULL_DATA_INPUT_AGAIN);
            return;
        }
        printResult(stub.updateStudentWithCourse(StudentAndCourseId.newBuilder().setStudentId(studentId).setCourseId(courseId).build()));
    }

    public void printResult(StatusCode statusCode) {
        String status = statusCode.getStatusCode();
        String message = statusCode.getMessage();

        switch (status) {
            case SCode.S200:
                System.out.println(ClientProps.success);
                break;
            case SCode.S402:// 이미 존재하는 id 입력
                if (message.equals(SCode.STUDENT)) System.out.println(ClientProps.alreadyEstd);
                else if (message.equals(SCode.COURSE)) System.out.println(ClientProps.alreadyEcourse);
                else System.out.println(ClientProps.fail);
            case SCode.S404:// 존재하지 않는 id 입력
                if (message.equals(SCode.STUDENT)) System.out.println(ClientProps.NOTexistIDstd);
                else if (message.equals(SCode.COURSE)) System.out.println(ClientProps.NOTexistIDcourse);
                else System.out.println(ClientProps.NOTexistDefault);
                break;
            case SCode.S410:// 선수과목을 수강하지 않았음
                System.out.println(ClientProps.HaveToTakePre);
                break;
            case SCode.S500:
                System.out.println(ClientProps.fail);
                break;
            default:
                System.out.println(ClientProps.systemError);
                break;
        }
    }



    //

//        if(status.equals(SCode.S200)){
//            System.out.println(ClientProps.success);
//        }
//        else if(status.equals(SCode.S402)){
//            if(message.equals(SCode.STUDENT)) System.out.println(ClientProps.alreadyEstd);
//            else if(message.equals(SCode.COURSE)) System.out.println(ClientProps.alreadyEcourse);
//        }
//        else if(status.equals(SCode.S404)){
//            if(message.equals(SCode.STUDENT)) System.out.println(ClientProps.NOTexistIDstd);
//            else if(message.equals(SCode.COURSE)) System.out.println(ClientProps.NOTexistIDcourse);
//            else System.out.println(ClientProps.NOTexistDefault);
//        }
//        else if(status.equals(SCode.S410)){
//            System.out.println(ClientProps.HaveToTakePre);
//        }
//        else if(status.equals(SCode.S500)){
//            System.out.println(ClientProps.fail);
//        }


    public void close() {
        System.out.println("프로그램 종료중...");
        Response close = stub.close(Request.newBuilder().build());
        if(close.getResponse().equals(ClientProps.OK)) {
            ServerConnection.disconnectPort();
            System.out.println(ClientProps.EXIT);
        }
    }
}
