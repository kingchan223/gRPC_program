package com.example.grpc.client;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import com.google.protobuf.ProtocolStringList;
import io.grpc.ManagedChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SCRegisterMethods {

    private static final String EMPTY = ClientProperties.EMPTY;

    public void getMenu(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) {
        MenuResponse response = stub.getMenu(MenuRequest.newBuilder().setRequest("1").build());
        for (String menu : response.getMenuListList()) System.out.println(menu);
    }

    public void printListData(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub, int n){
        if(n==1){
            ProtocolStringList students = stub.getListData(ListDataRequest.newBuilder().setStudentOrCourse("student").build()).getDataList();
            for (String student : students) System.out.println(student);
        }
         else if(n==2){
            ProtocolStringList courses = stub.getListData(ListDataRequest.newBuilder().setStudentOrCourse("course").build()).getDataList();
            for (String course : courses) System.out.println(course);
        }
    }

    public void putCourse(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        String id=""; String name=""; String profName=""; String[] preCourseStr = null;
        printPutCourseInfo(id, name, profName, preCourseStr);
        try {
            isNull(id, name, profName);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.NULL_DATA_INPUT_AGAIN);
            return;
        }
        List<String> preCourses = new ArrayList<>(Arrays.asList(preCourseStr));
        printResult(stub.putCourse(Course.newBuilder().setId(id).setName(name).setProfName(profName).addAllPreCourses(preCourses).build()));
    }

    public void putStudent(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        String id=""; String name=""; String major="";
        printPutStudentInfo(id, name, major);
        try {
            isNull(id, name, major);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.NULL_DATA_INPUT_AGAIN);
            return;
        }
        printResult(stub.putStudent(Student.newBuilder().setId(id).setName(name).setMajor(major).build()));
    }

    public void deleteStudent(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.STUDENT_DELETE_MESSAGE);
        String id = br.readLine().trim();
        try {
            isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_COURSE_NUM_AGAIN);
            return;
        }
        printResult(stub.deleteStudentById(StudentId.newBuilder().setStudentId(id).build()));
    }

    public void deleteCourse(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.COURSE_DELETE_MESSAGE);
        String id = br.readLine().trim();
        try {
            isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_COURSE_NUM_AGAIN);
            return;
        }
        printResult(stub.deleteCourseById(CourseId.newBuilder().setCourseId(id).build()));
    }

    public void updateStudentByAddCourse(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String studentId = ""; String courseId = "";
        printSCRegister(studentId, courseId);
        try {
            isNull(studentId);
            isNull(courseId);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_STUDENT_NUM_AGAIN);
        }
        printResult(stub.updateStudentWithCourse(StudentAndCourseId.newBuilder().setStudentId(studentId).setCourseId(courseId).build()));
    }

    public void printSCRegister(String studentId, String courseId) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.REGISTER_COURSE_STDID);
        studentId = br.readLine().trim();
        System.out.print(ClientProperties.REGISTER_COURSE_COURSEID);
        courseId = br.readLine().trim();
    }

    public void isNull(String  data1, String  data2, String  data3) throws NotEnoughDataException {
        nullOrEmpty(data1);
        nullOrEmpty(data2);
        nullOrEmpty(data3);
    }

    public void isNull(String  data) throws NotEnoughDataException {
        nullOrEmpty(data);
    }

    public void nullOrEmpty(String data) throws NotEnoughDataException {
        if(data != null && !data.equals(EMPTY)) throw new NotEnoughDataException();
    }

    public void printPutStudentInfo(String id, String name, String profName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.INPUT_ID_MSG);
        id = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_COURSENAME_MSG);
        name = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_PROFNAME_MSG);
        profName = br.readLine().trim();
    }

    public void printPutCourseInfo(String id, String name, String major, String[] preCourseStr) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.INPUT_ID_MSG);
        id = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_COURSENAME_MSG);
        name = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_PROFNAME_MSG);
        major = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_PRECOURSE_MSG);
        preCourseStr = br.readLine().trim().split("/");
    }

    public void printResult(StatusCode statusCode) {
        String status = statusCode.getStatusCode();
        String message = statusCode.getMessage();
        if(status.equals(SCode.S200)){
            System.out.println(ClientProperties.success);
        }
        else if(status.equals(SCode.S402)){
            if(message.equals(SCode.STUDENT)) System.out.println(ClientProperties.alreadyEstd);
            else if(message.equals(SCode.COURSE)) System.out.println(ClientProperties.alreadyEcourse);
        }
        else if(status.equals(SCode.S404)){
            if(message.equals(SCode.STUDENT)) System.out.println(ClientProperties.NOTexistIDstd);
            else if(message.equals(SCode.COURSE)) System.out.println(ClientProperties.NOTexistIDcourse);
            else System.out.println(ClientProperties.NOTexistDefault);
        }
        else if(status.equals(SCode.S410)){
            System.out.println(ClientProperties.HaveToTakePre);
        }
        else if(status.equals(SCode.S412)){
            System.out.println(ClientProperties.NULL_DATA_INPUT_AGAIN);
        }
        else if(status.equals(SCode.S500)){//500
            System.out.println(ClientProperties.fail);
        }
    }
}
