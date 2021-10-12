package com.example.grpc.data;

import com.example.exception.AlreadyExistIdException;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class CrudMethods {
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

    public boolean delete(String id, String fileName){

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

    public boolean update(String studentId, Map<Integer, String> courseIDListMap, StreamObserver<Message> responseObserver) {
        try {/*사용자가 입력한 studentId가 유효한지 확인*/
            if(!match(studentId, SCRSProperties.STUDENT_LIST_PATH, responseObserver)){
                Message msg = Message.newBuilder().setMsg("NOTexistIDstd").build();
                responseObserver.onNext(msg);
                responseObserver.onCompleted();
            }
        } catch (AlreadyExistIdException e) {
            e.printStackTrace();
            return false;
        }

        BufferedReader br = null;
        String all = "";
        try{
            br = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
            while (br.ready()) {
                String line = br.readLine();
                String[] splitLine = line.split(" ");
                /*수상신청을 해줘야하는 학생 발견!*/
                if(splitLine[0].equals(studentId)){
                    System.out.println(line);
                    /*이미 수강한 강좌는 아닌지 확인*/
                    boolean notTake = checkAlreadyTake(courseIDListMap, splitLine, responseObserver);
                    System.out.println("notTake:"+notTake);
                    /*수강신청한 courseID가 실제로 존재하는 courseID인지 확인하기*/
                    boolean exist = isExistCourse(courseIDListMap, responseObserver);
                    System.out.println("exist:"+exist);
                    if(notTake&&exist){
                        all += addCourseId(courseIDListMap, line)+ "\n";
                    }else{
                        all += line;
                    }
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
            fw = new FileWriter(SCRSProperties.STUDENT_LIST_PATH);
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

    public String addCourseId(Map<Integer, String> courseIDListMap, String line) {
        for (Integer i : courseIDListMap.keySet()) {
            line += " "+courseIDListMap.get(i);
        }
        return line;
    }

    public boolean isExistCourse(Map<Integer, String> courseIDListMap, StreamObserver<Message> responseObserver) {
        for (Integer i : courseIDListMap.keySet()) {
            String courseId = courseIDListMap.get(i);
            try {
                if(!match(courseId, SCRSProperties.COURSE_LIST_PATH, responseObserver)){
                    Message msg = Message.newBuilder().setMsg("NOTexistIDcourse").build();
                    responseObserver.onNext(msg);
                    responseObserver.onCompleted();
                    return false;
                }
            } catch (AlreadyExistIdException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean checkAlreadyTake(Map<Integer, String> courseIDListMap, String[] splitLine, StreamObserver<Message> responseObserver) {
        for (Integer i : courseIDListMap.keySet()) {
            String courseId = courseIDListMap.get(i);
            for(int j=splitLine.length;j>2; j--){
                if(splitLine.equals(courseId)){
                    Message msg = Message.newBuilder().setMsg("alreadyEcourse").build();
                    responseObserver.onNext(msg);
                    responseObserver.onCompleted();
                    return false;
                }
            }
        }
        return true;
    }

    //새로 입력한 info의 id와 이미 존재하는 fileName의 id를 비교하고 이미 있는 id이면 AlreadyExistIdException을 던잔다.
    public boolean match(String id, String fileName, StreamObserver<Message> responseObserver) throws AlreadyExistIdException{
        BufferedReader objStudentFile = null;
        try {
            objStudentFile = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            while (objStudentFile.ready()) {
                String line = objStudentFile.readLine();
                String[] alreadyId = line.split(" ");
                if(alreadyId[0].equals(id)){
                    objStudentFile.close();
                    return true;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

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

    public DataResponse.Builder putCourseInfo(DataResponse.Builder builder) {
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
