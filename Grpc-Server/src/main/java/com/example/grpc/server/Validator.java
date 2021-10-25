package com.example.grpc.server;

import com.example.grpc.*;
import com.example.grpc.exception.NotExistCourseIDException;
import com.google.protobuf.ProtocolStringList;

public class Validator {

    public boolean alreadyExist(Object obj){
        if(obj instanceof Student){
            Student student = (Student) obj;
             if(DataConnection.connect().getStudentById(StudentId.newBuilder().setStudentId(student.getId()).build()).getStudentInfo().equals(ServerProps.EMPTY)) return false;
        }
        else if(obj instanceof Course){
            Course course = (Course) obj;
           if(DataConnection.connect().getCourseById(CourseId.newBuilder().setCourseId(course.getId()).build()).getCourseInfo().equals(ServerProps.EMPTY)) return false;
        }
        else if(obj instanceof StudentId){
            StudentId studentID = (StudentId) obj;
            if(DataConnection.connect().getStudentById(StudentId.newBuilder().setStudentId(studentID.getStudentId()).build()).getStudentInfo().equals(ServerProps.EMPTY)) return false;
        }
        else if(obj instanceof CourseId){
            CourseId courseID = (CourseId) obj;
            if(DataConnection.connect().getCourseById(CourseId.newBuilder().setCourseId(courseID.getCourseId()).build()).getCourseInfo().equals(ServerProps.EMPTY)) return false;
        }
        return true;
    }

    public boolean alreadyExistCourse(String id){
        return !DataConnection.connect().getCourseById(CourseId.newBuilder().setCourseId(id).build()).getCourseInfo().equals(ServerProps.EMPTY);
    }

    public boolean alreadyExistStudent(String id){
        return !DataConnection.connect().getStudentById(StudentId.newBuilder().setStudentId(id).build()).getStudentInfo().equals(ServerProps.EMPTY);
    }

    public void checkPreCourse(ProtocolStringList preCoursesList) throws NotExistCourseIDException {
        for (String id : preCoursesList) if(!alreadyExistCourse(id)) throw new NotExistCourseIDException();
    }

    public boolean takePreCourse(String studentId, String courseId) {
        String courseInfo = DataConnection.connect().getCourseById(CourseId.newBuilder().setCourseId(courseId).build()).getCourseInfo();
        String studentInfo = DataConnection.connect().getStudentById(StudentId.newBuilder().setStudentId(studentId).build()).getStudentInfo();
        String[] splitCourse = courseInfo.split(ServerProps.SEPARATOR);
        if(splitCourse.length >= 3)
            for (int i = 3; i < splitCourse.length; i++)
                if(!studentInfo.contains(splitCourse[i])) return false;
        return true;
    }
}
