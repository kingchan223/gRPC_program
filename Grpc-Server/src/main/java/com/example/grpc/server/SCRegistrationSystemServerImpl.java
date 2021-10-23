package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.entity.StudentCourse;
import com.example.grpc.exception.NotEnoughDataException;
import com.example.grpc.exception.NotExistCourseIDException;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;

import java.util.Map;

public class SCRegistrationSystemServerImpl extends StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemImplBase {

    private static final StringMethods stringMethods = new StringMethods();
    private CheckAlreadyMethods check;

    public SCRegistrationSystemServerImpl() {
        check = new CheckAlreadyMethods();
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
            courseInfo = stringMethods.extractCourseInfo(course);
        }catch(NotEnoughDataException e){
            response(responseObserver,SCode.S412,SCode.NOTENOUGHDATA);
            return;
        }
        DataConnection.connect().putCourse(CourseInfoString.newBuilder().setCourseInfo(courseInfo).build());
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }

    @Override
    public void putStudent(Student student, StreamObserver<StatusCode> responseObserver){
        if(check.alreadyExist(student)) {
            response(responseObserver,SCode.S402,SCode.COURSE);
            return;
        }
        String studentInfo = null;
        try {
            studentInfo = stringMethods.extractStudentInfo(student);
        } catch(NotEnoughDataException e){
            response(responseObserver,SCode.S412,SCode.NOTENOUGHDATA);
            return;
        }
        DataConnection.connect().putCourse(CourseInfoString.newBuilder().setCourseInfo(studentInfo).build());
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }


    @Override
    public void deleteCourseById(CourseId courseId, StreamObserver<StatusCode> responseObserver){
        if(!check.alreadyExist(courseId)) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        StatusCode code = DataConnection.connect().deleteCourseById(CourseId.newBuilder().setCourseId(courseId.getCourseId()).build());
        response(responseObserver, code.getStatusCode(), code.getMessage());
    }

    @Override
    public void deleteStudentById(StudentId student, StreamObserver<StatusCode> responseObserver){
        if(!check.alreadyExist(student)) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        StatusCode code = DataConnection.connect().deleteStudentById(StudentId.newBuilder().setStudentId(student.getStudentId()).build());
        response(responseObserver, code.getStatusCode(), code.getMessage());
    }

    @Override
    public void updateStudentWithCourse(StudentAndCourseId request, StreamObserver<StatusCode> responseObserver){
        if(!check.alreadyExistCourse(request.getCourseId())
                || !check.alreadyExistStudent(request.getStudentId())
                || check.alreadyTake(request.getStudentId(), request.getStudentId())) {
            response(responseObserver,SCode.S404,SCode.FAIL);
            return;
        }
        StatusCode code = DataConnection.connect()
                .updateStudentWithCourse(StudentAndCourseId.newBuilder().setStudentId(request.getStudentId()).setCourseId(request.getCourseId()).build());
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
