package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.AlreadyExistCourseIDException;
import com.example.grpc.exception.AlreadyExistStudentIDException;
import com.example.grpc.exception.NotExistCourseIDException;
import com.example.grpc.exception.NotTakePreCourseException;
import com.google.protobuf.ProtocolStringList;

public class Validator {

    private final DataServiceGrpc.DataServiceBlockingStub stub;

    public Validator() {
        stub = DataConnection.connect();
    }

    public void alreadyExist(Object obj) throws AlreadyExistStudentIDException, AlreadyExistCourseIDException {
        if(obj instanceof Student){
            Student student = (Student) obj;
             if(stub.getStudentById(StudentId.newBuilder().setStudentId(student.getId()).build()).getStudentInfo().equals(ServerProps.EMPTY))
                 throw new AlreadyExistStudentIDException();
        }
        else if(obj instanceof Course){
            Course course = (Course) obj;
           if(stub.getCourseById(CourseId.newBuilder().setCourseId(course.getId()).build()).getCourseInfo().equals(ServerProps.EMPTY))
               throw new AlreadyExistCourseIDException();
        }
        else if(obj instanceof StudentId){
            StudentId studentID = (StudentId) obj;
            if(stub.getStudentById(StudentId.newBuilder().setStudentId(studentID.getStudentId()).build()).getStudentInfo().equals(ServerProps.EMPTY))
                throw new AlreadyExistStudentIDException();
        }
        else if(obj instanceof CourseId){
            CourseId courseID = (CourseId) obj;
            if(stub.getCourseById(CourseId.newBuilder().setCourseId(courseID.getCourseId()).build()).getCourseInfo().equals(ServerProps.EMPTY))
                throw new AlreadyExistCourseIDException();
        }
    }

    public void alreadyExistCourses(String id) throws AlreadyExistCourseIDException {
        if(!stub.getCourseById(CourseId.newBuilder().setCourseId(id).build()).getCourseInfo().equals(ServerProps.EMPTY))
            throw new AlreadyExistCourseIDException();
    }

    public void alreadyExistStudent(String id) throws AlreadyExistStudentIDException {
        if(!stub.getStudentById(StudentId.newBuilder().setStudentId(id).build()).getStudentInfo().equals(ServerProps.EMPTY))
            throw new AlreadyExistStudentIDException();
    }

    public void checkPreCourse(ProtocolStringList preCoursesList) throws NotExistCourseIDException{
        for (String id : preCoursesList) {
            try {
                alreadyExistCourses(id);
                throw new NotExistCourseIDException();
            } catch (AlreadyExistCourseIDException ignored) {}
        }
    }

    public void takePreCourse(String studentId, String courseId) throws NotTakePreCourseException {
        String courseInfo = stub.getCourseById(CourseId.newBuilder().setCourseId(courseId).build()).getCourseInfo();
        String studentInfo = stub.getStudentById(StudentId.newBuilder().setStudentId(studentId).build()).getStudentInfo();
        String[] splitCourse = courseInfo.split(ServerProps.SEPARATOR);
        if(splitCourse.length >= 3)
            for (int i = 3; i < splitCourse.length; i++)
                if(!studentInfo.contains(splitCourse[i])) throw new NotTakePreCourseException();
    }
}
