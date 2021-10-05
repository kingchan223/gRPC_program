package com.example.grpc.client;

import com.example.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.sql.DataSource;
import java.io.*;
import java.util.Map;

public class MyGrpcClient {
    public static void main(String[] args) throws IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=10;
        while(n!=7){
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
//                case 3:
//
//                    break;
//                case 4:
//
//                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("없는 번호를 입력하셨습니다.");
                    break;

            }
            System.out.println(ClientProperties.LINE);
        }
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
}
