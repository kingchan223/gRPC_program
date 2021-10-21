package com.example.grpc.client;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.sql.DataSource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//?????
public class MyGrpcClient {
    public static void main(String[] args) throws IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

//        testMethods(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=10;
        while(n!=8){
            getMenu(channel);
            try {
                n = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println(ClientProperties.INPUT_NUMBER);
                continue;
            } catch (NumberFormatException e2) {
                System.out.println(ClientProperties.INPUT_NUMBER);
                continue;
            }
            System.out.println(ClientProperties.LINE);
            switch(n){
                case 1:
                    getStudent(channel);
                    break;
                case 2:
                    getCouse(channel);
                    break;
                case 3://3. Add Students
                    putStudent(channel);
                    break;
                case 4://4. Add Courses
                    putCourse(channel);
                    break;
                case 5://5. Delete Student
                    deleteStudent(channel);
                    break;
                case 6://6. Delete Courses
                    deleteCourse(channel);
                    break;
                case 7://7. 수강신청
                    updateStudentByAddCourse(channel);
                    break;
                case 8:// 8.EXIT
                    System.out.println(ClientProperties.EXIT);
                    return;
                default:
                    System.out.println(ClientProperties.WRONG_NUM);
                    break;
            }
            System.out.println(ClientProperties.LINE);
        }
    }

    private static void testMethods(ManagedChannel channel){
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        TestResponse response = stub.testMethods(TestRequest.newBuilder().setTestRequests("hi").build());

//        response.getTestResponse();

        System.out.println(response.toString());
    }

    private static void updateStudentByAddCourse(ManagedChannel channel) throws IOException {
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
        Message message = stub.updateStudentWithCourse(StudentAndCourseId.newBuilder().setStudentId(studentId).setCourseId(courseId).build());
        printResultMessage(message);
    }

    private static void deleteStudent(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("삭제할 학생의 "+ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        try {
            isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_COURSE_NUM_AGAIN);
            return;
        }
        Message message = stub.deleteStudentById(Student.newBuilder().setId(id).build());
        printResultMessage(message);
    }

    private static void deleteCourse(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("삭제할 강좌의 "+ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        try {
            isNull(id);
        } catch (NotEnoughDataException e) {
            System.out.println(ClientProperties.INPUT_COURSE_NUM_AGAIN);
            return;
        }
        Message message = stub.deleteCourseById(Course.newBuilder().setId(id).build());
        printResultMessage(message);
    }

    private static void putCourse(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
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
        Message message = stub.putCourse(Course
                .newBuilder()
                .setId(id)
                .setName(name)
                .setProfName(profName)
                .putAllPreCourses(preCourseMap)
                .build());
        printResultMessage(message);
    }

    private static void putStudent(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
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
        Message message = stub.putStudent(Student
                .newBuilder()
                .setId(id)
                .setName(name)
                .setMajor(major)
                .build());
        printResultMessage(message);
    }

    private static void getCouse(ManagedChannel channel) {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        CourseListResponse response = stub.getCourseList(Request.newBuilder().setRequest(1).build());
        Map<Integer, String> courseListMap = response.getCourseListMap();
        for (Integer i : courseListMap.keySet()) {
            System.out.println(courseListMap.get(i));
        }
    }

    private static void getStudent(ManagedChannel channel) {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        StudentListResponse response = stub.getStudentList(Request.newBuilder().setRequest(1).build());
        Map<Integer, String> studentListMap = response.getStudentListMap();
        for (Integer i : studentListMap.keySet()) {
            System.out.println(studentListMap.get(i));
        }
    }

    private static void getMenu(ManagedChannel channel) {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        GetMenuResponse response = stub.getMenu(GetMenuRequest.newBuilder().setRequest("1").build());
        Map<Integer, String> menuListMap = response.getMenuListMap();
        for (Integer i : menuListMap.keySet()) {
            System.out.println(menuListMap.get(i));
        }
    }

    public static void isNull(String  data1, String  data2, String  data3) throws NotEnoughDataException {
        if((data1==null|| data1.equals("")) || (data2==null|| data2.equals("")) || (data3==null|| data3.equals(""))){
            throw new NotEnoughDataException();
        }
    }

    public static void isNull(String  data) throws NotEnoughDataException {
        if((data==null|| data.equals(""))){
            throw new NotEnoughDataException();
        }
    }

    private static void printResultMessage(StatusCode statusCode) {
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
