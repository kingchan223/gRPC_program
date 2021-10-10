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

    @Override
    public void getListData(DataRequest request, StreamObserver<DataResponse> responseObserver) {
        DataResponse.Builder builder = null;
        if(request.getSORc().equals("s")){
            builder = putStudentInfo(DataResponse.newBuilder());
        }else if(request.getSORc().equals("c")){
            builder = putCourseInfo(DataResponse.newBuilder());
        }
        assert builder != null;
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void addCourse(CourseInfoString courseInfoString, StreamObserver<Message> responseObserver) {
        try {
            writeCourse(courseInfoString);
        } catch (AlreadyExistIdException e) {
            Message alreadyException = Message.newBuilder().setMsg("already exist id").build();
            responseObserver.onNext(alreadyException);
            responseObserver.onCompleted();
            e.printStackTrace();
        }
        Message ok = Message.newBuilder().setMsg("saved!").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }

    @Override
    public void addStudent(StudentInfoString studentInfoString, StreamObserver<Message> responseObserver) {
        try {
            writeStudent(studentInfoString);
        } catch (AlreadyExistIdException e) {
            Message alreadyException = Message.newBuilder().setMsg("already exist id").build();
            responseObserver.onNext(alreadyException);
            responseObserver.onCompleted();
            e.printStackTrace();
        }
        Message ok = Message.newBuilder().setMsg("saved!").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }

    public void writeStudent(StudentInfoString studentInfoString) throws AlreadyExistIdException {
        String studentInfo = studentInfoString.getStudentInfo();
        String studentID = studentInfo.split(" ")[0];
        studentInfo = "\n\n"+studentInfoString.getStudentInfo();
        match(studentID, SCRSProperties.STUDENT_LIST_PATH);

        try {
            Files.write(Paths.get(SCRSProperties.STUDENT_LIST_PATH), studentInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCourse(CourseInfoString courseInfoString) throws AlreadyExistIdException {
        String courseInfo = courseInfoString.getCourseInfo();
        String[] courseInfoArray = courseInfo.split(" ");
        String courseID = courseInfoArray[0];
        courseInfo = "\n\n"+courseInfo;
        match(courseID, SCRSProperties.COURSE_LIST_PATH);

        try {
            Files.write(Paths.get(SCRSProperties.COURSE_LIST_PATH), courseInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourseById(Course request, StreamObserver<Message> responseObserver) {
        String id = request.getId();
        try {
            if(match(id, SCRSProperties.COURSE_LIST_PATH)){
                Message msg = Message.newBuilder().setMsg("there No ID Like "+id).build();
                responseObserver.onNext(msg);
                responseObserver.onCompleted();
            }
        } catch (AlreadyExistIdException e) {
            e.printStackTrace();
        }
        boolean yORn = delete(id, SCRSProperties.COURSE_LIST_PATH);
        Message msg = null;
        if(yORn){
            msg = Message.newBuilder().setMsg("deleted!").build();
        }else{
            msg = Message.newBuilder().setMsg("fail to delete").build();
        }
        responseObserver.onNext(msg);
        responseObserver.onCompleted();
    }

    private boolean delete(String id, String fileName){

        BufferedReader br = null;
        String all = "";
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        try{
            while (br.ready()) {
                assert br != null;
                String line = br.readLine();
                String[] alreadyId = line.split(" ");
                if(alreadyId[0].equals(id)){
                    continue;
                }else{
                    all += line + "\n";
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
            return false;
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try {
            fw.write(all);
            fw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void deleteStudentById(Student request, StreamObserver<Message> responseObserver)  {
        String id = request.getId();
        try {
            if(match(id, SCRSProperties.STUDENT_LIST_PATH)){
                Message msg = Message.newBuilder().setMsg("there No ID Like "+id).build();
                responseObserver.onNext(msg);
                responseObserver.onCompleted();
            }
        } catch (AlreadyExistIdException e) {
            e.printStackTrace();
        }
        boolean yORn = delete(id, SCRSProperties.STUDENT_LIST_PATH);
        Message msg = null;
        if(yORn){
            msg = Message.newBuilder().setMsg("deleted!").build();
        }else{
            msg = Message.newBuilder().setMsg("fail to delete").build();
        }
        responseObserver.onNext(msg);
        responseObserver.onCompleted();
    }

    @Override
    public void registerCourseByStudent(StuAndCourseInfo request, StreamObserver<Message> responseObserver) {
        super.registerCourseByStudent(request, responseObserver);
    }

    //새로 입력한 info의 id와 이미 존재하는 fileName의 id를 비교하고 이미 있는 id이면 AlreadyExistIdException을 던잔다.
    public boolean match(String id, String fileName) throws AlreadyExistIdException{
        int i = 0;
        BufferedReader objStudentFile = null;
        try {
            objStudentFile = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            while (objStudentFile.ready()) {
                assert objStudentFile != null;
                String line = objStudentFile.readLine();
                String[] alreadyId = line.split(" ");
                if(alreadyId[0].equals(id)){
                    objStudentFile.close();
                    return false;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try {
            objStudentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public DataResponse.Builder putStudentInfo(DataResponse.Builder builder){
        int i = 0;
        BufferedReader objStudentFile = null;
        try {/*우리가 만든 익셉션 로직 여기에 추가하기*/
            objStudentFile = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        String all = "";
        try{
            while (objStudentFile.ready()) {
                String stuInfo = objStudentFile.readLine();
//                all += stuInfo+"\n";
                if (!stuInfo.equals("")) {
                    builder.putData(i++,stuInfo);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        try {
            objStudentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(all);
        return builder;
    }

    private DataResponse.Builder putCourseInfo(DataResponse.Builder builder) {
        int i = 0;
        BufferedReader objStudentFile = null;
        try {
            objStudentFile = new BufferedReader(new FileReader(SCRSProperties.COURSE_LIST_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            while (objStudentFile.ready()) {
                String courseInfo = objStudentFile.readLine();
                if (!courseInfo.equals("")) {
                    builder.putData(i++,courseInfo);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        try {
            objStudentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }
}
