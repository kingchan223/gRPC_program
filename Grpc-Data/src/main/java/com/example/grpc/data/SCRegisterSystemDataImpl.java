package com.example.grpc.data;

import com.example.grpc.*;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class SCRegisterSystemDataImpl extends DataServiceGrpc.DataServiceImplBase {

    private final CrudMethods crudMethods;
    public SCRegisterSystemDataImpl() {
        this.crudMethods = new CrudMethods();
    }
    @Override
    public void getListData(ListDataRequest request, StreamObserver<ListDataResponse> responseObserver){
        ListDataResponse.Builder builder = null;
        if(request.getStudentOrCourse().equals(SCode.STUDENT)) builder = crudMethods.getAllStudentData(ListDataResponse.newBuilder());
        else if(request.getStudentOrCourse().equals(SCode.COURSE)) builder = crudMethods.getAllCourseData(ListDataResponse.newBuilder());
        response(responseObserver, builder);
    }

    @Override
    public void getStudentById(StudentId studentId, StreamObserver<StudentInfoString> responseObserver) {
        String studentInfoString = crudMethods.getStudentById(studentId.getStudentId());
        responseObserver.onNext(StudentInfoString.newBuilder().setStudentInfo(studentInfoString).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCourseById(CourseId courseId, StreamObserver<CourseInfoString> responseObserver) {
        String courseInfoString = crudMethods.getCourseById(courseId.getCourseId());
        responseObserver.onNext(CourseInfoString.newBuilder().setCourseInfo(courseInfoString).build());
        responseObserver.onCompleted();
    }

    @Override
    public void putCourse(CourseInfoString courseInfoString, StreamObserver<StatusCode> responseObserver) {
        try {
            crudMethods.putCourse(courseInfoString);
        }
        catch (Exception e) {
            response(responseObserver,SCode.S500,SCode.FAIL);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }

    @Override
    public void putStudent(StudentInfoString studentInfoString, StreamObserver<StatusCode> responseObserver) {
        try {
            crudMethods.putStudent(studentInfoString);
        }
        catch (Exception e) {
            response(responseObserver,SCode.S500,SCode.FAIL);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }

    @Override
    public void deleteCourseById(CourseId request, StreamObserver<StatusCode> responseObserver) {
        try {
            crudMethods.deleteById(request.getCourseId(), DataProps.COURSE_LIST_PATH);
        }
        catch (Exception e) {
            response(responseObserver,SCode.S500,SCode.FAIL);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }
    @Override
    public void deleteStudentById(StudentId request, StreamObserver<StatusCode> responseObserver)  {
        try {
            crudMethods.deleteById(request.getStudentId(), DataProps.STUDENT_LIST_PATH);
        }
        catch (Exception e) {
            response(responseObserver, SCode.S500, SCode.FAIL);
            return;
        }
        response(responseObserver,SCode.S200, SCode.SUCCESS);
    }
    @Override
    public void updateStudentWithCourse(EditStudentInfoString request, StreamObserver<StatusCode> responseObserver) {
        try{ crudMethods.updateStudent(request.getStudentInfoString()); }
        catch(Exception e) {
            response(responseObserver, SCode.S500, SCode.FAIL);
            return;
        }
        response(responseObserver,SCode.S200, SCode.SUCCESS);
    }
    @Override
    public void close(Request request, StreamObserver<Response> responseObserver) {
        responseObserver.onNext(Response.newBuilder().setResponse(DataProps.OK).build());
        responseObserver.onCompleted();
        SCRegisterData.closeData();
    }
    private void response(StreamObserver<ListDataResponse> responseObserver, ListDataResponse.Builder builder) {
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
    private void response(StreamObserver<StatusCode> responseObserver, String code, String message) {
        responseObserver.onNext(makeStatusCode(StatusCode.newBuilder(), code, message));
        responseObserver.onCompleted();
    }
    public StatusCode makeStatusCode(StatusCode.Builder statusCodeBuilder, String code, String message){
        return statusCodeBuilder.setStatusCode(code).setMessage(message).build();
    }
}
