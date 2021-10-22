package com.example.grpc.client;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import io.grpc.ManagedChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SCRegisterMethods {

    private static final String EMPTY = ClientProperties.EMPTY;

    public void getMenu(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) {
        MenuResponse response = stub.getMenu(MenuRequest.newBuilder().setRequest("1").build());
        for (String s : response.getMenuListList())
            System.out.println(s);
    }

//    public void getCouse(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) {
////        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
//        stub.getListData()
//        CourseListResponse response = stub.getCourseList(Request.newBuilder().setRequest(1).build());
//        Map<Integer, String> courseListMap = response.getCourseListMap();
//        for (Integer i : courseListMap.keySet()) {
//            System.out.println(courseListMap.get(i));
//        }
//    }
//
//    public void getStudent(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) {
//        StudentListResponse response = stub.getStudentList(Request.newBuilder().setRequest(1).build());
//        Map<Integer, String> studentListMap = response.getStudentListMap();
//        for (Integer i : studentListMap.keySet()) {
//            System.out.println(studentListMap.get(i));
//        }
//    }

    public getListData(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub, int n){
        if(n==1) CourseListResponse response = stub.getListData(ListDataRequest.newBuilder().setStudentOrCourse("student").build());
        else if(n==2) StudentListResponse response = stub.getStudentList(Request.newBuilder().setRequest(1).build());
    }

    public void putCourse(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_COURSENAME_MSG);
        String name = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_PROFNAME_MSG);
        String profName = br.readLine().trim();
        try {
            isNull(id, name, profName);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.NULL_DATA_INPUT_AGAIN);
            return;
        }
        System.out.print(ClientProperties.INPUT_PRECOURSE_MSG);
        String[] preCourseStr = br.readLine().trim().split("/");
        Map<Integer, String> preCourseMap = new HashMap<>();
        int i=0;
        for (String preCourse : preCourseStr) {
            preCourseMap.put(i++,preCourse);
        }
        StatusCode code = stub.putCourse(Course
                .newBuilder()
                .setId(id)
                .setName(name)
                .setProfName(profName)
                .putAllPreCourses(preCourseMap)
                .build());
        printResultMessage(code);
    }

    public void putStudent(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_NAME_MSG);
        String name = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_MAJOR_MSG);
        String major = br.readLine().trim();
        try {
            isNull(id, name, major);
        } catch (NotEnoughDataException e) {
            System.out.println();
            System.out.println(ClientProperties.NULL_DATA_INPUT_AGAIN);
            return;
        }
        StatusCode code = stub.putStudent(Student
                .newBuilder()
                .setId(id)
                .setName(name)
                .setMajor(major)
                .build());
        printResultMessage(code);
    }

    public void deleteStudent(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("삭제할 학생의 "+ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        try {
            isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_COURSE_NUM_AGAIN);
            return;
        }
        StatusCode code = stub.deleteStudentById(Student.newBuilder().setId(id).build());
        printResultMessage(code);
    }

    public void deleteCourse(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("삭제할 강좌의 "+ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        try {
            isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_COURSE_NUM_AGAIN);
            return;
        }
        StatusCode code = stub.deleteCourseById(CourseId.newBuilder().setCourseId(id).build());
        printResultMessage(code);
    }

    public void updateStudentByAddCourse(StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.REGISTER_COURSE_STDID);
        String studentId = br.readLine().trim();
        try {
            isNull(studentId);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_STUDENT_NUM_AGAIN);
        }
        System.out.print(ClientProperties.REGISTER_COURSE_COURSEID);
        String courseId = br.readLine().trim();
        try {
            isNull(courseId);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_STUDENT_NUM_AGAIN);
        }
        Integer.parseInt(studentId);
        StatusCode code = stub.updateStudentWithCourse(StudentAndCourseId.newBuilder().setStudentId(studentId).setCourseId(courseId).build());
        printResultMessage(code);
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

    public void printResultMessage(StatusCode statusCode) {
        String status = statusCode.getStatusCode();
        if(status.equals("NOTexistIDstd")){//404
            System.out.println();
            System.out.println(ClientProperties.NOTexistIDstd);
        }else if(status.equals("alreadyEcourse")){//402
            System.out.println();
            System.out.println(ClientProperties.alreadyEcourse);
        }else if(status.equals("alreadyEstd")){//402
            System.out.println();
            System.out.println(ClientProperties.alreadyEstd);
        }else if(status.equals("NOTexistIDcourse")){//404
            System.out.println();
            System.out.println(ClientProperties.NOTexistIDcourse);
        }else if(status.equals("success")){//200
            System.out.println();
            System.out.println(ClientProperties.success);
        }else if(status.equals("fail")){//500
            System.out.println();
            System.out.println(ClientProperties.fail);
        }else if(status.equals("NOTexistID")){//404
            System.out.println();
            System.out.println(ClientProperties.NOTexistID);
        } else if(status.equals("HaveToTakePre")){//410
            System.out.println();
            System.out.println(ClientProperties.HaveToTakePre);
        }
    }
}
