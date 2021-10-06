package com.example.grpc.server;

import com.example.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class StudentCourseRegistrationSystemImpl extends StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemImplBase {

    private final DataConnection dataConnection;

    public StudentCourseRegistrationSystemImpl() {
        this.dataConnection = new DataConnection();
    }

    @Override
    public void printMenu(PrintMenuRequest request, StreamObserver<PrintMenuResponse> responseObserver) {
        getMenuList(responseObserver);
        responseObserver.onCompleted();
    }

    private void getMenuList(StreamObserver<PrintMenuResponse> responseObserver) {
        responseObserver.onNext(PrintMenuResponse.newBuilder()
                .putMenuList(1, "select menu number")
                .putMenuList(2, "1. List Students ")
                .putMenuList(3, "2. List Courses")
                .putMenuList(4, "3. Add Students")
                .putMenuList(5, "4. Add Courses")
                .putMenuList(6, "7. EXIT")
                .build());
    }

    @Override
    public void printStudentList(Request request, StreamObserver<StudentListResponse> responseObserver) {
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        DataResponse studentData = stub.getListData(DataRequest.newBuilder().setSORc("s").build());
        StudentListResponse.Builder builder = putStudentInfo(StudentListResponse.newBuilder(), studentData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }


    @Override
    public void printCourseList(Request request, StreamObserver<CourseListResponse> responseObserver) {
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        DataResponse courseData = stub.getListData(DataRequest.newBuilder().setSORc("c").build());
        CourseListResponse.Builder builder = putCourseInfo(CourseListResponse.newBuilder(), courseData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }


    @Override
    public void addCourse(Course request, StreamObserver<Message> responseObserver) {
        /*----------------------test--------------------------*/
        System.out.println(request.getName());
        Map<Integer, String> preCoursesMap = request.getPreCoursesMap();
        for (Integer integer : preCoursesMap.keySet()) {
            System.out.println(preCoursesMap.get(integer));
        }
        /*----------------------------------------------------*/
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        Message message = extractCourseInfo(request, stub);
        responseObserver.onNext(message);
        responseObserver.onCompleted();

    }

    private Message extractCourseInfo(Course request, DataSourceGrpc.DataSourceBlockingStub stub) {
        Message message = stub.addCourse(Course.newBuilder()
                .setId(request.getId())
                .setName(request.getName())
                .setProfName(request.getProfName())
                .putAllPreCourses(request.getPreCoursesMap())
                .build());
        return message;
    }

    @Override
    public void addStudent(Student request, StreamObserver<Message> responseObserver) {
        /*----------------------test--------------------------*/
        System.out.println(request.getName());
        Map<Integer, String> preCoursesMap = request.getTakeCoursesMap();
        for (Integer integer : preCoursesMap.keySet()) {
            System.out.println(preCoursesMap.get(integer));
        }
        /*----------------------------------------------------*/
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        Message message = extractStudentInfo(request, stub);
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    private Message extractStudentInfo(Student request, DataSourceGrpc.DataSourceBlockingStub stub) {
        Message message = stub.addStudent(Student.newBuilder()
                .setId(request.getId())
                .setName(request.getName())
                .setMajor(request.getMajor())
                .putAllTakeCourses(request.getTakeCoursesMap())
                .build());
        return message;
    }

    @Override
    public void deleteCourseById(Course request, StreamObserver<Message> responseObserver) {
        super.deleteCourseById(request, responseObserver);
    }

    @Override
    public void deleteStudentById(Student request, StreamObserver<Message> responseObserver) {
        super.deleteStudentById(request, responseObserver);
    }

    @Override
    public void registerCourseByStudent(StuAndCourseInfo request, StreamObserver<Message> responseObserver) {
        super.registerCourseByStudent(request, responseObserver);
    }

    @Override
    public void studentCourseList(StudentIdRequest request, StreamObserver<StudentIdResponse> responseObserver) {
        super.studentCourseList(request, responseObserver);
    }

    @Override
    public void courseIdStudentList(CourseIdRequest request, StreamObserver<CourseIdResponse> responseObserver) {
        super.courseIdStudentList(request, responseObserver);
    }

    public StudentListResponse.Builder putStudentInfo(StudentListResponse.Builder builder, DataResponse data){
        Map<Integer, String> dataMap = data.getDataMap();
        for (Integer i : dataMap.keySet()) {
            builder.putStudentList(i,dataMap.get(i));
        }
        return builder;
    }

    private CourseListResponse.Builder putCourseInfo(CourseListResponse.Builder builder, DataResponse data) {
        Map<Integer, String> dataMap = data.getDataMap();
        for (Integer i : dataMap.keySet()) {
            builder.putCourseList(i,dataMap.get(i));
        }
        return builder;
    }
}
