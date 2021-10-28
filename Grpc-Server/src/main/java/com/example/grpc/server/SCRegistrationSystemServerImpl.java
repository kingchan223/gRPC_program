package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.AlreadyExistCourseIDException;
import com.example.grpc.exception.AlreadyExistStudentIDException;
import com.example.grpc.exception.NotExistCourseIDException;
import com.example.grpc.exception.NotTakePreCourseException;
import io.grpc.stub.StreamObserver;

public class SCRegistrationSystemServerImpl extends StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemImplBase {

    private final StringMethods stringMethods;
    private final Validator validator;
    private final DataServiceGrpc.DataServiceBlockingStub stub;
    public SCRegistrationSystemServerImpl() {
        validator = new Validator();
        stringMethods = new StringMethods();
        stub = DataConnection.connect();
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

        try {
            validator.alreadyExist(course);
        } catch (AlreadyExistCourseIDException | AlreadyExistStudentIDException e) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        try {
            validator.checkPreCourse(course.getPreCoursesList());
        } catch (NotExistCourseIDException e) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        String courseInfo = stringMethods.makeCourseInfoString(course);
        StatusCode statCode = stub.putCourse(CourseInfoString.newBuilder().setCourseInfo(courseInfo).build());
        response(responseObserver, statCode.getStatusCode(), statCode.getMessage());
    }

    @Override
    public void putStudent(Student student, StreamObserver<StatusCode> responseObserver) {
        try {
            validator.alreadyExistStudent(student.getId());
        } catch (AlreadyExistStudentIDException e) {
            System.out.println("Exception이 발생하면 출력된다. 해당 catch문에서 바로 Client로 응답하기 때문에 Data Server로 요청하지 않는다.");
            response(responseObserver,SCode.S402,SCode.STUDENT);
            return;
        }
        String studentInfo = stringMethods.makeStudentInfoString(student);
        StatusCode statCode = stub.putStudent(StudentInfoString.newBuilder().setStudentInfo(studentInfo).build());
        response(responseObserver,statCode.getStatusCode(),statCode.getMessage());
    }

    @Override
    public void deleteCourseById(CourseId courseId, StreamObserver<StatusCode> responseObserver){
        try {
            validator.alreadyExist(courseId);
        } catch (AlreadyExistStudentIDException | AlreadyExistCourseIDException e) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        StatusCode statCode = stub.deleteCourseById(CourseId.newBuilder().setCourseId(courseId.getCourseId()).build());
        response(responseObserver, statCode.getStatusCode(), statCode.getMessage());
    }

    @Override
    public void deleteStudentById(StudentId student, StreamObserver<StatusCode> responseObserver){
        try {
            validator.alreadyExist(student);
        } catch (AlreadyExistStudentIDException | AlreadyExistCourseIDException e) {
            response(responseObserver,SCode.S404,SCode.STUDENT);
            return;
        }
        StatusCode statCode = stub.deleteStudentById(StudentId.newBuilder().setStudentId(student.getStudentId()).build());
        response(responseObserver, statCode.getStatusCode(), statCode.getMessage());
    }

    @Override
    public void updateStudentWithCourse(StudentAndCourseId request, StreamObserver<StatusCode> responseObserver){
        try {
            validator.alreadyExistCourses(request.getCourseId());
        } catch (AlreadyExistCourseIDException e) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }

        try {
            validator.alreadyExistStudent(request.getStudentId());
        } catch (AlreadyExistStudentIDException e) {
            response(responseObserver,SCode.S404,SCode.STUDENT);
            return;
        }

        try {
            validator.takePreCourse(request.getStudentId(), request.getStudentId());
        } catch (NotTakePreCourseException e) {
            response(responseObserver,SCode.S410,SCode.COURSE);
            return;
        }
        String studentStr = stub.getStudentById(StudentId.newBuilder().setStudentId(request.getStudentId()).build()).getStudentInfo();
        StatusCode code = stub.updateStudentWithCourse(EditStudentInfoString.newBuilder().setStudentInfoString(stringMethods.makeSeparatorString(studentStr, request.getCourseId())).build());
        response(responseObserver, code.getStatusCode(), code.getMessage());
    }

    @Override
    public void close(Request request, StreamObserver<Response> responseObserver) {
        Response close = stub.close(Request.newBuilder().build());
        responseObserver.onNext(Response.newBuilder().setResponse(ServerProps.OK).build());
        responseObserver.onCompleted();
        if(close.getResponse().equals(ServerProps.OK)){
            DataConnection.disconnectPort();
            SCRegisterServer.closeServer();
        }
    }

    private void response(StreamObserver<StatusCode> responseObserver, String code, String message) {
        responseObserver.onNext(makeStatusCode(StatusCode.newBuilder(), code, message));
        responseObserver.onCompleted();
    }

    public StatusCode makeStatusCode(StatusCode.Builder statusCodeBuilder, String code, String message){
        return statusCodeBuilder.setStatusCode(code).setMessage(message).build();
    }
}
