package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.entity.StudentCourse;
import com.example.grpc.exception.NotEnoughDataException;
import com.example.grpc.exception.NotExistCourseIDException;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;

import java.util.Map;

public class SCRegistrationSystemServerImpl extends StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemImplBase {

    private static StringMethods stringMethods;
    private CheckAlreadyMethods check;

    public SCRegistrationSystemServerImpl() {
        check = new CheckAlreadyMethods();
        stringMethods = new StringMethods();
    }

    @Override
    public void getMenu(MenuRequest request, StreamObserver<MenuResponse> responseObserver) {
        stringMethods.getMenuList(responseObserver);
        responseObserver.onCompleted();
    }

    @Override
    public void getListData(ListDataRequest request, StreamObserver<ListDataResponse> responseObserver){
        ListDataResponse listData = DataConnection.connect().getListData(ListDataRequest.newBuilder().setStudentOrCourse(request.getStudentOrCourse()).build());
        responseObserver.onNext(ListDataResponse.newBuilder().addData(stringMethods.makeDataString(listData)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void putCourse(Course course, StreamObserver<StatusCode> responseObserver){
        if(check.alreadyExist(course)) {
            response(responseObserver,SCode.S402,SCode.COURSE);
            return;
        }
        try {
            check.checkPreCourse(course.getPreCoursesList());
        } catch (NotExistCourseIDException e) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            e.printStackTrace();
        }
        String courseInfo = null;
        try{
            courseInfo = stringMethods.makeCourseInfoString(course);
        }catch(NotEnoughDataException e){
            response(responseObserver,SCode.S412,SCode.NOTENOUGHDATA);
            return;
        }
        StatusCode statCode = DataConnection.connect().putCourse(CourseInfoString.newBuilder().setCourseInfo(courseInfo).build());
        response(responseObserver, statCode.getStatusCode(), statCode.getMessage());
    }

    @Override
    public void putStudent(Student student, StreamObserver<StatusCode> responseObserver){
        if(check.alreadyExist(student)) {
            response(responseObserver,SCode.S402,SCode.COURSE);
            return;
        }
        String studentInfo = null;
        try {
            studentInfo = stringMethods.makeStudentInfoString(student);
        } catch(NotEnoughDataException e){
            response(responseObserver,SCode.S412,SCode.NOTENOUGHDATA);
            return;
        }
        StatusCode statCode = DataConnection.connect().putCourse(CourseInfoString.newBuilder().setCourseInfo(studentInfo).build());
        response(responseObserver,statCode.getStatusCode(),statCode.getMessage());
    }

    @Override
    public void deleteCourseById(CourseId courseId, StreamObserver<StatusCode> responseObserver){
        if(!check.alreadyExist(courseId)) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        StatusCode statCode = DataConnection.connect().deleteCourseById(CourseId.newBuilder().setCourseId(courseId.getCourseId()).build());
        response(responseObserver, statCode.getStatusCode(), statCode.getMessage());
    }

    @Override
    public void deleteStudentById(StudentId student, StreamObserver<StatusCode> responseObserver){
        if(!check.alreadyExist(student)) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        StatusCode statCode = DataConnection.connect().deleteStudentById(StudentId.newBuilder().setStudentId(student.getStudentId()).build());
        response(responseObserver, statCode.getStatusCode(), statCode.getMessage());
    }

    @Override
    public void updateStudentWithCourse(StudentAndCourseId request, StreamObserver<StatusCode> responseObserver){
        if(!check.alreadyExistCourse(request.getCourseId())){
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        if(!check.alreadyExistStudent(request.getStudentId())){
            response(responseObserver,SCode.S404,SCode.STUDENT);
            return;
        }
        if(check.takePreCourse(request.getStudentId(), request.getStudentId())){
            response(responseObserver,SCode.S410,SCode.FAIL);
            return;
        }
        String studentStr = DataConnection.connect().getStudentById(StudentId.newBuilder().setStudentId(request.getStudentId()).build()).getStudentInfo();
        StatusCode code = DataConnection.connect()
                .updateStudentWithCourse(EditStudentInfoString
                        .newBuilder()
                        .setStudentInfoString(stringMethods.makeSeparatorString(studentStr, request.getCourseId())).build());
        response(responseObserver, code.getStatusCode(), code.getMessage());
    }

    private void response(StreamObserver<StatusCode> responseObserver, String code, String message) {
        responseObserver.onNext(makeStatusCode(StatusCode.newBuilder(), code, message));
        responseObserver.onCompleted();
    }

    public StatusCode makeStatusCode(StatusCode.Builder statusCodeBuilder, String code, String message){
        return statusCodeBuilder.setStatusCode(code).setMessage(message).build();
    }
}
