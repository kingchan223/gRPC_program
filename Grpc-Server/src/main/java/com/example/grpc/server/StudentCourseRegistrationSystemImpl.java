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
                .putMenuList(4, "3. Add Students")
                .putMenuList(5, "4. Add Courses")
                .putMenuList(6, "5. Delete Students")
                .putMenuList(7, "6. Delete Courses")
                .putMenuList(8, "7. 수강신청")
                .putMenuList(10,"8. EXIT")
                .build());
    }

    @Override
    public void printStudentList(Request request, StreamObserver<StudentListResponse> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        DataResponse studentData = stub.getListData(DataRequest.newBuilder().setSORc("s").build());
        StudentListResponse.Builder builder = putStudentInfo(StudentListResponse.newBuilder(), studentData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void printCourseList(Request request, StreamObserver<CourseListResponse> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        DataResponse courseData = stub.getListData(DataRequest.newBuilder().setSORc("c").build());
        CourseListResponse.Builder builder = putCourseInfo(CourseListResponse.newBuilder(), courseData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
//    Message message = stub.addCourse(CourseInfoString.newBuilder().setCourseInfo(courseInfo).build());
    @Override
    public void addCourse(Course request, StreamObserver<Message> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        String courseInfo = extractCourseInfo(request, stub);
        Message message = stub.addCourse(CourseInfoString.newBuilder().setCourseInfo(courseInfo).build());
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    private String extractCourseInfo(Course request, DataSourceGrpc.DataSourceBlockingStub stub){
        return
                  request.getId() +" "
                + request.getName() +" "
                + request.getProfName() +" "
                + makeOneStrFromMap(request.getPreCoursesMap());
    }

    @Override
    public void addStudent(Student request, StreamObserver<Message> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        Message message = extractStudentInfo(request, stub);
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }



    private Message extractStudentInfo(Student request, DataSourceGrpc.DataSourceBlockingStub stub){
        String studentInfo =
                          request.getId() +" "
                        + request.getName()+" "
                        + request.getMajor()+" "
                        + makeOneStrFromMap(request.getTakeCoursesMap());
        return stub.addStudent(StudentInfoString.newBuilder().setStudentInfo(studentInfo).build());
    }

    private String makeOneStrFromMap(Map<Integer, String> map){
        String retVal = "";
        for (Integer i : map.keySet()) {
            retVal += map.get(i)+" ";
        }
        return retVal;
    }

    @Override
    public void deleteCourseById(Course request, StreamObserver<Message> responseObserver){
        String id = request.getId();
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        Message message = stub.deleteCourseById(Course.newBuilder().setId(id).build());
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudentById(Student request, StreamObserver<Message> responseObserver){
        String id = request.getId();
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        Message message = stub.deleteStudentById(Student.newBuilder().setId(id).build());
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    @Override
    public void registerCourseByStudent(StuAndCourseInfo request, StreamObserver<Message> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        Message message = stub.registerCourseByStudent(StuAndCourseInfo
                .newBuilder()
                .setStudentId(request.getStudentId())
                .putAllCourseIDList(request.getCourseIDListMap())
                .build());
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    public StudentListResponse.Builder putStudentInfo(StudentListResponse.Builder builder, DataResponse data){
        Map<Integer, String> dataMap = data.getDataMap();
        for (Integer i : dataMap.keySet()) {
            builder.putStudentList(i,dataMap.get(i));
        }
        return builder;
    }

    private CourseListResponse.Builder putCourseInfo(CourseListResponse.Builder builder, DataResponse data){
        Map<Integer, String> dataMap = data.getDataMap();
        for (Integer i : dataMap.keySet()) {
            builder.putCourseList(i,dataMap.get(i));
        }
        return builder;
    }
}
