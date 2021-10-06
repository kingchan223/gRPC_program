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
    public void addCourse(Course request, StreamObserver<Message> responseObserver) {
        try {
           writeCourse(request);
        } catch (AlreadyExistIdException e) {
            Message alreadyException = Message.newBuilder().setMsg("alreadyException").build();
            responseObserver.onNext(alreadyException);
            responseObserver.onCompleted();
            e.printStackTrace();
        }
        Message ok = Message.newBuilder().setMsg("ok").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }

    @Override
    public void addStudent(Student request, StreamObserver<Message> responseObserver) {
        try {
            writeStudent(request);
        } catch (AlreadyExistIdException e) {
            Message alreadyException = Message.newBuilder().setMsg("alreadyException").build();
            responseObserver.onNext(alreadyException);
            responseObserver.onCompleted();
            e.printStackTrace();
        }
        Message ok = Message.newBuilder().setMsg("ok").build();
        responseObserver.onNext(ok);
        responseObserver.onCompleted();
    }

    public void writeStudent(Student request) throws AlreadyExistIdException {

        String id = request.getId();
        match(id, SCRSProperties.STUDENT_LIST_PATH);

        String[] name = request.getName().split("/");
        Map<Integer, String> takeCoursesMap = request.getTakeCoursesMap();
        String major = request.getMajor();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(SCRSProperties.STUDENT_LIST_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert fileWriter != null;
        BufferedWriter bw = new BufferedWriter(fileWriter);
        StringBuilder s = new StringBuilder();
        for (Integer integer : takeCoursesMap.keySet()) {
            s.append(takeCoursesMap.get(integer)).append(" ");
        }
        try {
            bw.write(id + " " + name[0] + " "+name[1]+" " + major + " "+s+"\n\n\n");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCourse(Course request) throws AlreadyExistIdException {
        String id = request.getId();
        match(id, SCRSProperties.COURSE_LIST_PATH);
        String name = request.getName();
        Map<Integer, String> preCoursesMap = request.getPreCoursesMap();
        String profName = request.getProfName();
//
//        try {
//            Files.write(Paths.get(SCRSProperties.COURSE_LIST_PATH), "the text".getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(SCRSProperties.COURSE_LIST_PATH);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        assert fileWriter != null;
//        BufferedWriter bw = new BufferedWriter(fileWriter);
        StringBuilder s = new StringBuilder();
        for (Integer integer : preCoursesMap.keySet()) {
            s.append(preCoursesMap.get(integer)).append(" ");
        }
        System.out.println(id + " " + profName + " " + name + " "+s);
//        try {
//            bw.write(id + " " + profName + " " + name + " "+s+"\n\n\n");
//            bw.newLine();
//            bw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void deleteCourseById(Course request, StreamObserver<Message> responseObserver) {
        super.deleteCourseById(request, responseObserver);
    }

    @Override
    public void deleteStudentById(Student request, StreamObserver<Message> responseObserver) {
        super.deleteStudentById(request, responseObserver);
    }

    @Override
    public void registerCourseByStudent(StuAndCourseInfo request, StreamObserver<Message> responseObserver) {
        super.registerCourseByStudent(request, responseObserver);
    }

    //새로 입력한 info의 id와 이미 존재하는 fileName의 id를 비교하고 이미 있는 id이면 AlreadyExistIdException을 던잔다.
    public void match(String id, String fileName) throws AlreadyExistIdException{
        int i = 0;
        BufferedReader objStudentFile = null;
        try {
            objStudentFile = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            while (true) {
                assert objStudentFile != null;
                if (!objStudentFile.ready()) break;
                String line = objStudentFile.readLine();
                String[] alreadyId = line.split(" ");
                if(alreadyId.equals(id)) throw new AlreadyExistIdException();
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
    }

    public DataResponse.Builder putStudentInfo(DataResponse.Builder builder){
        int i = 0;
        BufferedReader objStudentFile = null;
        try {/*우리가 만든 익셉션 로직 여기에 추가하기*/
            objStudentFile = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            while (objStudentFile.ready()) {
                String stuInfo = objStudentFile.readLine();
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
