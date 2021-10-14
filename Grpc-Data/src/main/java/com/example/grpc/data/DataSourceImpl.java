package com.example.grpc.data;

import com.example.exception.AlreadyExistCourseIDException;
import com.example.exception.AlreadyExistStudentIDException;
import com.example.exception.NotExistCourseIDException;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
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
        } catch (AlreadyExistCourseIDException e) {
            Message msg = Message.newBuilder().setMsg("alreadyEcourse").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            log.error("사용자가 이미 존재하는 강좌번호를 추가하는 시도했습니다.");
            return;
        }
        catch (NotExistCourseIDException e2) {
            Message msg = Message.newBuilder().setMsg("NOTexistIDcourse").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            log.error("사용자가 존재하지 않는 강좌번호를 입력했습니다.");
            return;
        }
        Message ok = Message.newBuilder().setMsg("success").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }

    @Override
    public void addStudent(StudentInfoString studentInfoString, StreamObserver<Message> responseObserver) {
        try {
            crudMethods.writeStudent(studentInfoString);
        } catch (AlreadyExistStudentIDException e) {
            Message msg = Message.newBuilder().setMsg("alreadyEstd").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            log.error("사용자가 이미 존재하는 학생번호를 추가하는 시도했습니다.");
            return;
        }
        catch (NotExistCourseIDException e2) {
            Message msg = Message.newBuilder().setMsg("NOTexistIDcourse").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            log.error("사용자가 존재하지 않는 강좌번호를 입력했습니다.");
            return;
        }
        Message ok = Message.newBuilder().setMsg("success").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCourseById(Course request, StreamObserver<Message> responseObserver) {
        String id = request.getId();
        boolean yORn = crudMethods.delete(id, SCRSProperties.COURSE_LIST_PATH, responseObserver);
        Message msg = null;
        if(yORn) msg = Message.newBuilder().setMsg("success").build();
        else msg = Message.newBuilder().setMsg("fail").build();
        responseObserver.onNext(msg);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudentById(Student request, StreamObserver<Message> responseObserver)  {
        String id = request.getId();
        boolean yORn = crudMethods.delete(id, SCRSProperties.STUDENT_LIST_PATH, responseObserver);
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
