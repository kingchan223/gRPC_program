package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import io.grpc.stub.StreamObserver;

import java.util.Map;

public class
SCRegistrationSystemServerImpl extends StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemImplBase {

    private final DataConnection dataConnection;

    public SCRegistrationSystemServerImpl() {
        this.dataConnection = new DataConnection();
    }

//    @Override
//    public void testMethods(TestRequest request, StreamObserver<TestResponse> responseObserver) {
//        responseObserver.onNext(TestResponse.newBuilder()
//                .addTestResponse("stringstringstringstringstringstringstringstringstringstringstringstring")
//                .addTestResponse("stringstringstringstringstringstringstringstringstringstringstringstring")
//                .addTestResponse("stringstringstringstringstringstringstringstringstringstringstringstringstring")
//                .addTestResponse("stringstringstringstringstringstringstringstringstringstringstringstringstringstringstring")
//                .addTestResponse("stringstringstringstringstringstringstringstringstringstringstring")
//                .addTestResponse("stringstringstringstringstringstringstringstringstringstringstringstringstring")
//                .build());
//        responseObserver.onCompleted();
//    }

    @Override
    public void getMenu(MenuRequest request, StreamObserver<MenuResponse> responseObserver) {
        getMenuList(responseObserver);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentList(Request request, StreamObserver<StudentListResponse> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        DataResponse studentData = stub.getListData(DataRequest.newBuilder().setSORc("s").build());
        StudentListResponse.Builder builder = putStudentInfo(StudentListResponse.newBuilder(), studentData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCourseList(Request request, StreamObserver<CourseListResponse> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        DataResponse courseData = dataConnection.makeStub().getListData(DataRequest.newBuilder().setSORc("c").build());
        CourseListResponse.Builder builder = putCourseInfo(CourseListResponse.newBuilder(), courseData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void putCourse(Course request, StreamObserver<Message> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        String courseInfo = null;
        try{
            courseInfo = extractCourseInfo(request);
        }catch(NotEnoughDataException e){
            Message msg = Message.newBuilder().setMsg("nullData").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            e.printStackTrace();
            return;
        }
        Message message = stub.putCourse(CourseInfoString.newBuilder().setCourseInfo(courseInfo).build());
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    @Override
    public void putStudent(Student request, StreamObserver<Message> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        String studentInfo = null;
        try {
            studentInfo = extractStudentInfo(request);
        } catch (NotEnoughDataException e) {
            Message msg = Message.newBuilder().setMsg("nullData").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            e.printStackTrace();
            return;
        }
        Message message = stub.putStudent(StudentInfoString.newBuilder().setStudentInfo(studentInfo).build());
        responseObserver.onNext(message);
        responseObserver.onCompleted();
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
    public void updateStudentByAddCourse(StuAndCourseInfo request, StreamObserver<Message> responseObserver){
        DataSourceGrpc.DataSourceBlockingStub stub = dataConnection.makeStub();
        Message message = stub.updateStudentByAddCourse(StuAndCourseInfo
                .newBuilder()
                .setStudentId(request.getStudentId())
                .setCourseId(request.getCourseId())
                .build());
        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    private String extractCourseInfo(Course request) throws NotEnoughDataException {
        String id = request.getId();
        String name = request.getName();
        String profName = request.getProfName();
        isNull(id, name, profName);
        return id +" " + name +" " + profName +" " + makeOneStrFromMap(request.getPreCoursesMap());
    }

    private String extractStudentInfo(Student request) throws NotEnoughDataException {
        String id = request.getId();
        String name = request.getName();
        String major = request.getMajor();
        isNull(id, name, major);
        return id +" " + name+" " + major+" ";
    }

    private String makeOneStrFromMap(Map<Integer, String> map){
        String oneStr = "";
        for (Integer i : map.keySet())
            oneStr += map.get(i)+" ";
        return oneStr;
    }

    public StudentListResponse.Builder putStudentInfo(StudentListResponse.Builder builder, DataResponse data){
        Map<Integer, String> dataMap = data.getDataMap();
        for (Integer i : dataMap.keySet())
            builder.putStudentList(i,dataMap.get(i));
        return builder;
    }

    private CourseListResponse.Builder putCourseInfo(CourseListResponse.Builder builder, DataResponse data){
        Map<Integer, String> dataMap = data.getDataMap();
        for (Integer i : dataMap.keySet()) {
            builder.putCourseList(i,dataMap.get(i));
        }
        return builder;
    }
    private void getMenuList(StreamObserver<MenuResponse> responseObserver) {
        responseObserver.onNext(MenuResponse.newBuilder()
                .addMenuList("select menu number")
                .addMenuList("1. List Students ")
                .addMenuList("2. List Courses")
                .addMenuList("3. Add Students")
                .addMenuList("4. Add Courses")
                .addMenuList("5. Delete Students")
                .addMenuList("6. Delete Courses")
                .addMenuList("7. 수강신청")
                .addMenuList("8. EXIT")
                .build());
    }

    public static void isNull(String  data1, String  data2, String  data3) throws NotEnoughDataException {
        if((data1==null|| data1.equals("")) || (data2==null|| data2.equals("")) || (data3==null|| data3.equals("")))
            throw new NotEnoughDataException();
    }
}
