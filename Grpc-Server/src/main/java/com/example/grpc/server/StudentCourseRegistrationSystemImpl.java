package com.example.grpc.server;

import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
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
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
//        stub
    }

    @Override
    public void addStudent(Student request, StreamObserver<Message> responseObserver) {
        super.addStudent(request, responseObserver);
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
