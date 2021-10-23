package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.NotExistCourseIDException;
import com.google.protobuf.ProtocolStringList;

public class CheckAlreadyMethods {

    public boolean alreadyExist(Object obj){
        if(obj instanceof Student){
            Student student = (Student) obj;
             if(DataConnection.connect()
                     .getStudentById(StudentId.newBuilder().setStudentId(student.getId()).build())
                     .getStudentInfo().equals(SCRSProperties.EMPTY)) return false;
        }
        else if(obj instanceof Course){
            Course course = (Course) obj;
           if(DataConnection.connect()
                   .getCourseById(CourseId.newBuilder().setCourseId(course.getId()).build())
                   .getCourseInfo().equals(SCRSProperties.EMPTY)) return false;
        }
        else if(obj instanceof StudentId){
            StudentId studentID = (StudentId) obj;
            if(DataConnection.connect()
                    .getCourseById(CourseId.newBuilder().setCourseId(studentID.getStudentId()).build())
                    .getCourseInfo().equals(SCRSProperties.EMPTY))
                return false;
        }
        else if(obj instanceof CourseId){
            CourseId courseID = (CourseId) obj;
            if(DataConnection.connect()
                    .getCourseById(CourseId.newBuilder().setCourseId(courseID.getCourseId()).build())
                    .getCourseInfo().equals(SCRSProperties.EMPTY))
            return false;
        }
        return true;
    }

    public boolean alreadyExistCourse(String id){
        return DataConnection.connect().getCourseById(CourseId.newBuilder().setCourseId(id).build()).getStatusCode().equals(SCode.S200);
    }

    public boolean alreadyExistStudent(String id){
        return DataConnection.connect().getStudentById(StudentId.newBuilder().setStudentId(id).build()).getStatusCode().equals(SCode.S200);
    }

    public void checkPreCourse(ProtocolStringList preCoursesList) throws NotExistCourseIDException {
        for (String id : preCoursesList) if(alreadyExistCourse(id)) throw new NotExistCourseIDException();
    }

    public boolean alreadyTake(String studentId, String courseId) {

    }
}
