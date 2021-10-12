package com.example.grpc.data;

import com.example.exception.AlreadyExistIdException;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class DataSourceImpl extends DataSourceGrpc.DataSourceImplBase {

    private final CrudMethods crudMethods;

    public DataSourceImpl() {
        this.crudMethods = new CrudMethods();
    }

    @Override
    public void getListData(DataRequest request, StreamObserver<DataResponse> responseObserver) {
        DataResponse.Builder builder = null;
        if(request.getSORc().equals("s")) builder = crudMethods.putStudentInfo(DataResponse.newBuilder());
        else if(request.getSORc().equals("c")) builder = crudMethods.putCourseInfo(DataResponse.newBuilder());
        assert builder != null;
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void addCourse(CourseInfoString courseInfoString, StreamObserver<Message> responseObserver) {
        try {
            crudMethods.writeCourse(courseInfoString);
        } catch (AlreadyExistIdException e) {
            Message alreadyException = Message.newBuilder().setMsg("alreadyEcourse").build();
            responseObserver.onNext(alreadyException);
            responseObserver.onCompleted();
            e.printStackTrace();
        }
        Message ok = Message.newBuilder().setMsg("success").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }

    @Override
    public void addStudent(StudentInfoString studentInfoString, StreamObserver<Message> responseObserver) {
        try {
            crudMethods.writeStudent(studentInfoString);
        } catch (AlreadyExistIdException e) {
            Message alreadyException = Message.newBuilder().setMsg("alreadyEstd").build();
            responseObserver.onNext(alreadyException);
            responseObserver.onCompleted();
            e.printStackTrace();
        }
        Message ok = Message.newBuilder().setMsg("success").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }



    @Override
    public void deleteCourseById(Course request, StreamObserver<Message> responseObserver) {
        String id = request.getId();
        try {
            if(!crudMethods.match(id, SCRSProperties.COURSE_LIST_PATH, responseObserver)){
                Message msg = Message.newBuilder().setMsg("NOTexistIDcourse").build();
                responseObserver.onNext(msg);
                responseObserver.onCompleted();
            }
        } catch (AlreadyExistIdException e) {
            e.printStackTrace();
        }
        boolean yORn = crudMethods.delete(id, SCRSProperties.COURSE_LIST_PATH);
        Message msg = null;
        if(yORn) msg = Message.newBuilder().setMsg("success").build();
        else msg = Message.newBuilder().setMsg("fail").build();
        responseObserver.onNext(msg);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudentById(Student request, StreamObserver<Message> responseObserver)  {
        String id = request.getId();
        try {
            if(!crudMethods.match(id, SCRSProperties.STUDENT_LIST_PATH, responseObserver)){
                Message msg = Message.newBuilder().setMsg("NOTexistIDstd").build();
                responseObserver.onNext(msg);
                responseObserver.onCompleted();
            }
        } catch (AlreadyExistIdException e) {
            e.printStackTrace();
        }
        boolean yORn = crudMethods.delete(id, SCRSProperties.STUDENT_LIST_PATH);
        Message msg = null;
        if(yORn) msg = Message.newBuilder().setMsg("success").build();
        else msg = Message.newBuilder().setMsg("fail").build();

        responseObserver.onNext(msg);
        responseObserver.onCompleted();
    }

    @Override
    public void registerCourseByStudent(StuAndCourseInfo request, StreamObserver<Message> responseObserver) {
        String studentId = request.getStudentId();
        Map<Integer, String> courseIDListMap = request.getCourseIDListMap();
        if(crudMethods.update(studentId, courseIDListMap, responseObserver)){
            Message msg = Message.newBuilder().setMsg("success").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
        }
    }
}
