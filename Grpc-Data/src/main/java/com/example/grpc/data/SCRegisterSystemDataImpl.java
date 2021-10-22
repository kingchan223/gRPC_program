package com.example.grpc.data;

import com.example.exception.*;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class SCRegisterSystemDataImpl extends DataServiceGrpc.DataServiceImplBase {

    private final CrudMethods crudMethods;

    public SCRegisterSystemDataImpl() {
        this.crudMethods = new CrudMethods();
    }

    @Override
    public void getListData(ListDataRequest request, StreamObserver<ListDataResponse> responseObserver) {
        ListDataResponse.Builder builder = null;
        if(request.getStudentOrCourse().equals(SCode.STUDENT)) builder = crudMethods.getStudentData(ListDataResponse.newBuilder());
        else if(request.getStudentOrCourse().equals(SCode.COURSE)) builder = crudMethods.getCourseData(ListDataResponse.newBuilder());
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void putCourse(CourseInfoString courseInfoString, StreamObserver<StatusCode> responseObserver) {
        try {
            crudMethods.putCourse(courseInfoString);
        } catch (AlreadyExistCourseIDException e) {
            response(responseObserver,SCode.S402,SCode.COURSE);
            return;
        }
        catch (NotExistCourseIDException e2) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }

    @Override
    public void putStudent(StudentInfoString studentInfoString, StreamObserver<StatusCode> responseObserver) {
        try {
            crudMethods.putStudent(studentInfoString);
        } catch (AlreadyExistStudentIDException e) {
            response(responseObserver,SCode.S402,SCode.STUDENT);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }

    @Override
    public void deleteCourseById(CourseId request, StreamObserver<StatusCode> responseObserver) {
        try {
            crudMethods.delete(request.getCourseId(), SCRSProperties.COURSE_LIST_PATH);
        } catch (NotExistIDException e) {
            response(responseObserver,SCode.S404,SCode.COURSE);
            return;
        }
        response(responseObserver,SCode.S200,SCode.SUCCESS);
    }

    @Override
    public void deleteStudentById(StudentId request, StreamObserver<StatusCode> responseObserver)  {
        try {
            crudMethods.delete(request.getStudentId(), SCRSProperties.STUDENT_LIST_PATH);
        } catch (NotExistIDException e) {
            response(responseObserver, SCode.S404, SCode.STUDENT);
            return;
        }
        response(responseObserver,SCode.S200, SCode.SUCCESS);
    }


    @Override
    public void updateStudentWithCourse(StudentAndCourseId request, StreamObserver<StatusCode> responseObserver) {
        try{
            crudMethods.updateStudent(request.getStudentId(), request.getCourseId());
        }
        catch(NotExistStudentIDException e){
            response(responseObserver,SCode.S404, SCode.STUDENT);
            return;
        }
        catch(NotExistCourseIDException e1){
            response(responseObserver,SCode.S404, SCode.COURSE);
            return;
        }
        catch(AlreadyTakeCourseIDException e2){
            response(responseObserver,SCode.S402, SCode.COURSE);
            return;
        }
        catch(NotTakePreCourseException e3){
            response(responseObserver,SCode.S410, SCode.COURSE);
            return;
        }
        response(responseObserver,SCode.S200, SCode.SUCCESS);
    }

    private void response(StreamObserver<StatusCode> responseObserver, String code, String message) {
        responseObserver.onNext(makeStatusCode(StatusCode.newBuilder(), code, message));
        responseObserver.onCompleted();
    }

    public StatusCode makeStatusCode(StatusCode.Builder statusCodeBuilder, String code, String message){
        return statusCodeBuilder.setStatusCode(code).setMessage(message).build();
    }

}
