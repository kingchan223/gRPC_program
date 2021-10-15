package com.example.grpc.data;

import com.example.exception.*;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
public class CrudMethods {

    public void writeStudent(StudentInfoString studentInfoString) throws AlreadyExistStudentIDException, NotExistCourseIDException {
        String studentInfo = studentInfoString.getStudentInfo();
        String studentID = studentInfo.split(" ")[0];
        studentInfo = "\n\n"+studentInfoString.getStudentInfo();
        if(match(studentID, SCRSProperties.STUDENT_LIST_PATH)) throw new AlreadyExistStudentIDException();
        try {
            Files.write(Paths.get(SCRSProperties.STUDENT_LIST_PATH), studentInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            log.error("IOException");
        }
    }

    public void writeCourse(CourseInfoString courseInfoString) throws AlreadyExistCourseIDException, NotExistCourseIDException {
        String courseInfo = courseInfoString.getCourseInfo();
        String[] courseInfoArray = courseInfo.split(" ");
        String courseID = courseInfoArray[0];
        if(match(courseID, SCRSProperties.COURSE_LIST_PATH)) throw new AlreadyExistCourseIDException();
        if(courseInfoArray.length>3)
            for(int i=courseInfoArray.length-1; i>=3; i--)
                if(!match(courseInfoArray[i], SCRSProperties.COURSE_LIST_PATH)) throw new NotExistCourseIDException();

        courseInfo = "\n\n"+courseInfo;
        try {
            Files.write(Paths.get(SCRSProperties.COURSE_LIST_PATH), courseInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(String id, String fileName, StreamObserver<Message> responseObserver){
        try{
            if(!match(id, fileName)){
                throw new NotExistIDException();
            }
        }catch(NotExistIDException e){
            Message msg = Message.newBuilder().setMsg("NOTexistID").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            e.printStackTrace();
            return false;
        }

        BufferedReader br = null;
        String all = "";
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException");
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
            fw.write(all);
            fw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public boolean update(String studentId, String courseId, StreamObserver<Message> responseObserver) {
        try {/*사용자가 입력한 studentId가 유효한지 확인*/
            if(!match(studentId, SCRSProperties.STUDENT_LIST_PATH)){
                throw new NotExistStudentIDException();
            }
        } catch (NotExistStudentIDException e) {
            Message msg = Message.newBuilder().setMsg("NOTexistIDstd").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            log.error("사용자가 존재하지 않는 학생번호를 입력했습니다.");
            return false;
        }

        BufferedReader br = null;
        String all = "";
        try{
            br = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
            while (br.ready()) {
                String studentLine = br.readLine();
                String[] splitStudentLine = studentLine.split(" ");
                if(splitStudentLine[0].equals(studentId)){
                    System.out.println(studentLine);
                    System.out.println("update시작");
                    if(checkAlreadyTake(courseId, splitStudentLine, responseObserver)
                            &&isExistCourse(courseId, responseObserver)
                            &&checkPreTakeCourse(studentLine, courseId, responseObserver))
                        all += addCourseId(courseId, studentLine)+ "\n";
                    else
                        all += studentLine;
                }else
                    all += studentLine + "\n";
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


    // 12345          1111 2222
    private boolean checkPreTakeCourse(String studentInfoLine, String courseId, StreamObserver<Message> responseObserver) {
        ArrayList<String> preCourseList = getPreCourseListOfCourse(courseId);
        try {
            checkHavePreCourse(preCourseList, studentInfoLine);
        } catch (NotTakePreCourseException e) {
            Message msg = Message.newBuilder().setMsg("HaveToTakePre").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<String> getPreCourseListOfCourse(String courseId){
        ArrayList<String> preCourseList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(SCRSProperties.COURSE_LIST_PATH));
            while (br.ready()) {
                String courseLine = br.readLine();
                String[] courseLineSplit = courseLine.split(" ");
                if(courseLineSplit[0].equals(courseId)){
                    makePreCourseList(courseId, preCourseList, courseLineSplit);
                    return preCourseList;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return preCourseList;
    }

    private void makePreCourseList(String courseId, ArrayList<String> preCourseList, String[] courseLineSplit) {

        for (int j = courseLineSplit.length - 1; j > 2; j--) {
            preCourseList.add(courseLineSplit[j]);
        }
    }

    private void checkHavePreCourse(ArrayList<String> preCourseList, String studentInfoLine) throws NotTakePreCourseException {
        for (String preCourse : preCourseList) {
            if(!studentInfoLine.contains(preCourse)) throw new NotTakePreCourseException();
        }
    }


    public String addCourseId(String courseId, String line) {
        line += " "+courseId;
        return line;
    }

    public boolean isExistCourse(String courseId, StreamObserver<Message> responseObserver) {
        try {
            if(!match(courseId, SCRSProperties.COURSE_LIST_PATH)){
                throw new NotExistCourseIDException();
            }
        } catch (NotExistCourseIDException e) {
            Message msg = Message.newBuilder().setMsg("NOTexistIDcourse").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            log.error("사용자가 존재하지 않는 강좌를 수강신청했습니다.");
            return false;
        }
        return true;
    }

    public boolean checkAlreadyTake(String courseId, String[] splitLine, StreamObserver<Message> responseObserver) {
        try {
            for (String s : splitLine) {
                if(s.equals(courseId)) throw new AlreadyTakeCourseIDException();
            }
        }catch(AlreadyTakeCourseIDException e){
            Message msg = Message.newBuilder().setMsg("alreadyEcourse").build();
            responseObserver.onNext(msg);
            responseObserver.onCompleted();
            log.error("사용자가 이미 수강한 강좌의 수강신청을 시도했습니다.");
            return false;
        }
        return true;
    }

    //id와 일치하면 true반환
    public boolean match(String id, String fileName){
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
