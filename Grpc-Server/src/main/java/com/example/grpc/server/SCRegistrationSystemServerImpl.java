package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.NotEnoughDataException;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;

import java.util.Map;

public class SCRegistrationSystemServerImpl extends StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemImplBase {

    private static final StringMethods stringMethods = new StringMethods();

    @Override
    public void getMenu(MenuRequest request, StreamObserver<MenuResponse> responseObserver) {
        stringMethods.getMenuList(responseObserver);
        responseObserver.onCompleted();
    }

    @Override
    public void getListData(ListDataRequest request, StreamObserver<ListDataResponse> responseObserver){
        ListDataResponse listData = DataConnection.connect()
                .getListData(ListDataRequest.newBuilder().setStudentOrCourse(request.getStudentOrCourse()).build());
        responseObserver.onNext(ListDataResponse.newBuilder().addData(listData.toString()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void putCourse(Course course, StreamObserver<StatusCode> responseObserver){
        try{
            DataConnection.connect()
                    .putCourse(CourseInfoString.newBuilder().setCourseInfo(stringMethods.extractCourseInfo(course)).build());
        }catch(NotEnoughDataException e){
            response(responseObserver,SCode.S412,SCode.NOTENOUGHDATA);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }

    @Override
    public void putStudent(Student student, StreamObserver<StatusCode> responseObserver){
        try {
            DataConnection.connect()
                    .putStudent(StudentInfoString.newBuilder().setStudentInfo(stringMethods.extractStudentInfo(student)).build());
        } catch(NotEnoughDataException e){
            response(responseObserver,SCode.S412,SCode.NOTENOUGHDATA);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }


    @Override
    public void deleteCourseById(CourseId courseId, StreamObserver<StatusCode> responseObserver){
        StatusCode code = DataConnection.connect()
                .deleteCourseById(CourseId.newBuilder().setCourseId(courseId.getCourseId()).build());
        response(responseObserver, code.getStatusCode(), code.getMessage());
    }

    @Override
    public void deleteStudentById(StudentId student, StreamObserver<StatusCode> responseObserver){
        StatusCode code = DataConnection.connect()
                .deleteStudentById(StudentId.newBuilder().setStudentId(student.getStudentId()).build());
        response(responseObserver, code.getStatusCode(), code.getMessage());
    }

    @Override
    public void updateStudentWithCourse(StudentAndCourseId request, StreamObserver<StatusCode> responseObserver){
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
