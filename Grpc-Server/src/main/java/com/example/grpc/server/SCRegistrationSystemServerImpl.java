package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import io.grpc.stub.StreamObserver;

import java.util.Map;

public class
SCRegistrationSystemServerImpl extends StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemImplBase {


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
    public void getStudentList(ListDataRequest request, StreamObserver<StudentListResponse> responseObserver){
        ListDataResponse studentData = DataConnection.getDataConnection().makeStub().getListData(ListDataRequest.newBuilder().setStudentOrCourse("student").build());
        StudentListResponse.Builder builder = putStudentInfo(StudentListResponse.newBuilder(), studentData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCourseList(ListDataRequest request, StreamObserver<CourseListResponse> responseObserver){
        ListDataResponse courseData = DataConnection.getDataConnection().makeStub().getListData(ListDataRequest.newBuilder().setStudentOrCourse("course").build());
        CourseListResponse.Builder builder = putCourseInfo(CourseListResponse.newBuilder(), courseData);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void putCourse(Course request, StreamObserver<StatusCode> responseObserver){
        try{
            String courseInfo = extractCourseInfo(request);
        }catch(NotEnoughDataException e){
            StatusCode code = StatusCode.newBuilder().setStatusCode("nullData").build();
            responseObserver.onNext(code);
            responseObserver.onCompleted();
            e.printStackTrace();
            return;
        }
        StatusCode code = DataConnection.getDataConnection().makeStub().putCourse(CourseInfoString.newBuilder().setCourseInfo(courseInfo).build());
        responseObserver.onNext(code);
        responseObserver.onCompleted();
    }

    @Override
    public void putStudent(Student request, StreamObserver<StatusCode> responseObserver){
        String studentInfo = null;
        try {
            studentInfo = extractStudentInfo(request);
        } catch (NotEnoughDataException e) {
            StatusCode code = StatusCode.newBuilder().setStatusCode("nullData").build();
            responseObserver.onNext(code);
            responseObserver.onCompleted();
            e.printStackTrace();
            return;
        }
        StatusCode code = DataConnection.getDataConnection().makeStub().putStudent(StudentInfoString.newBuilder().setStudentInfo(studentInfo).build());
        responseObserver.onNext(code);
        responseObserver.onCompleted();
    }


    @Override
    public void deleteCourseById(CourseId courseId, StreamObserver<StatusCode> responseObserver){
        String id = courseId.getCourseId();
        DataServiceGrpc.DataServiceBlockingStub stub = DataConnection.getDataConnection().makeStub();
        StatusCode code = stub.deleteCourseById(Course.newBuilder().setId(id).build());
        responseObserver.onNext(code);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudentById(Student student, StreamObserver<StatusCode> responseObserver){
        String id = student.getId();
        DataServiceGrpc.DataServiceBlockingStub stub = DataConnection.getDataConnection().makeStub();
        StatusCode code = stub.deleteStudentById(Student.newBuilder().setId(id).build());
        responseObserver.onNext(code);
        responseObserver.onCompleted();
    }

    @Override
    public void updateStudentWithCourse(StudentAndCourseId request, StreamObserver<StatusCode> responseObserver){
        StatusCode code = DataConnection.getDataConnection().makeStub().updateStudentWithCourse(StudentAndCourseId
                .newBuilder()
                .setStudentId(request.getStudentId())
                .setCourseId(request.getCourseId())
                .build());
        responseObserver.onNext(code);
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
