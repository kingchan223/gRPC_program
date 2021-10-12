package com.example.grpc.client;

import com.example.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.sql.DataSource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyGrpcClient {
    public static void main(String[] args) throws IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=10;
        while(n!=8){
            printMenu(channel);
            n = Integer.parseInt(br.readLine());
            System.out.println(ClientProperties.LINE);
            switch(n){
                case 1:
                    printStudent(channel);
                    break;
                case 2:
                    printCouse(channel);
                    break;
                case 3://3. Add Students
                    addStudent(channel);
                    break;
                case 4://4. Add Courses
                    addCourse(channel);
                    break;
                case 5://5. Delete Student
                    DeleteStudent(channel);
                    break;
                case 6://6. Delete Courses
                    DeleteCourse(channel);
                    break;
                case 7://7. 수강신청
                    addCourseByStudent(channel);
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
    private static void addCourseByStudent(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.REGISTER_COURSE_STDID);
        String studentId = br.readLine().trim();
        System.out.print(ClientProperties.REGISTER_COURSE_COURSEID);
        String[] courseIdList = br.readLine().trim().split("/");
        Map<Integer, String> courseIdMap = new HashMap<>();
        int i=0;
        for (String courseId : courseIdList) {
            courseIdMap.put(i++,courseId);
        }
        Message message = stub.registerCourseByStudent(StuAndCourseInfo
                .newBuilder()
                .setStudentId(studentId)
                .putAllCourseIDList(courseIdMap)
                .build());
        printResultMessage(message);
    }

    private static void DeleteStudent(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("삭제할 학생의 "+ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        Message message = stub.deleteStudentById(Student.newBuilder().setId(id).build());
        printResultMessage(message);
    }

    private static void DeleteCourse(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("삭제할 강좌의 "+ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        Message message = stub.deleteCourseById(Course.newBuilder().setId(id).build());
        printResultMessage(message);
    }

    private static void addCourse(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_COURSENAME_MSG);
        String name = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_PROFNAME_MSG);
        String profName = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_PRECOURSE_MSG);
        String[] preCourseList = br.readLine().trim().split("/");
        Map<Integer, String> preCourseMap = new HashMap<>();
        int i=0;
        for (String preCourse : preCourseList) {
            preCourseMap.put(i++,preCourse);
        }
        Message message = stub.addCourse(Course
                .newBuilder()
                .setId(id)
                .setName(name)
                .setProfName(profName)
                .putAllPreCourses(preCourseMap)
                .build());
        printResultMessage(message);
    }

    private static void addStudent(ManagedChannel channel) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ClientProperties.INPUT_ID_MSG);
        String id = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_NAME_MSG);
        String name = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_MAJOR_MSG);
        String major = br.readLine().trim();
        System.out.print(ClientProperties.INPUT_TAKECOURSE_MSG);
        String[] takeCourseList = br.readLine().trim().split("/");
        Map<Integer, String> takeCourseMap = new HashMap<>();
        int i=0;
        for (String preCourse : takeCourseList) {
            takeCourseMap.put(i++,preCourse);
        }
        Message message = stub.addStudent(Student
                .newBuilder()
                .setId(id)
                .setName(name)
                .setMajor(major)
                .putAllTakeCourses(takeCourseMap)
                .build());
        printResultMessage(message);
    }
    private static void printCouse(ManagedChannel channel) {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        CourseListResponse response = stub.printCourseList(Request.newBuilder().setRequest(1).build());
        Map<Integer, String> courseListMap = response.getCourseListMap();
        for (Integer i : courseListMap.keySet()) {
            System.out.println(courseListMap.get(i));
        }
    }

    private static void printStudent(ManagedChannel channel) {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        StudentListResponse response = stub.printStudentList(Request.newBuilder().setRequest(1).build());
        Map<Integer, String> studentListMap = response.getStudentListMap();
        for (Integer i : studentListMap.keySet()) {
            System.out.println(studentListMap.get(i));
        }
    }

    private static void printMenu(ManagedChannel channel) {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = StudentCourseRegistrationSystemGrpc.newBlockingStub(channel);
        PrintMenuResponse response = stub.printMenu(PrintMenuRequest.newBuilder().setRequest("1").build());
        Map<Integer, String> menuListMap = response.getMenuListMap();
        for (Integer i : menuListMap.keySet()) {
            System.out.println(menuListMap.get(i));
        }
    }

    private static void printResultMessage(Message message) {
        String msg = message.getMsg();
        if(msg.equals("NOTexistIDstd")){
            System.out.println("존재하지 않는 학생 아이디를 입력하셨습니다.");
        }else if(msg.equals("alreadyEcourse")){
            System.out.println("이미 수강신청한 강좌번호를 입력하셨습니다.");
        }else if(msg.equals("alreadyEstd")){
            System.out.println("이미 등록된 학생번호를 입력하셨습니다.");
        }else if(msg.equals("NOTexistIDcourse")){
            System.out.println("존재하지 않는 강좌번호를 입력하셨습니다.");
        }else if(msg.equals("success")){
            System.out.println("성공적으로 반영되었습니다.");
        }else if(msg.equals("fail")){
            System.out.println("알 수 없는 이유로 실패하였습니다. 다시 시도해주세요");
        }
    }
}
