package com.example.grpc.data;

import com.example.exception.*;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CrudMethods {

    public ListDataResponse.Builder getAllStudentData(ListDataResponse.Builder builder){
        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
            while (objStudentFile.ready()) {
                String stuInfo = objStudentFile.readLine();
                if (!stuInfo.equals(SCRSProperties.EMPTY)) builder.addData(stuInfo);
            }
            objStudentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    public ListDataResponse.Builder getAllCourseData(ListDataResponse.Builder builder) {
        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(SCRSProperties.COURSE_LIST_PATH));
            while (objStudentFile.ready()) {
                String courseInfo = objStudentFile.readLine();
                if (!courseInfo.equals(SCRSProperties.EMPTY)) builder.addData(courseInfo);
            }
            objStudentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    public String getStudentById(String studentId) {
        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
            while (objStudentFile.ready()) {
                String line = objStudentFile.readLine();
                String[] alreadyId = line.split(SCRSProperties.SEPARATOR);
                if(alreadyId[0].equals(studentId)){
                    objStudentFile.close();
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SCRSProperties.EMPTY;
    }

    public String getCourseById(String courseId) {
        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(SCRSProperties.COURSE_LIST_PATH));
            while (objStudentFile.ready()) {
                String line = objStudentFile.readLine();
                String[] alreadyId = line.split(SCRSProperties.SEPARATOR);
                if(alreadyId[0].equals(courseId)){
                    objStudentFile.close();
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SCRSProperties.EMPTY;
    }

    public void putStudent(StudentInfoString studentInfoString){
        try {
            Files.write(Paths.get(SCRSProperties.STUDENT_LIST_PATH), (SCRSProperties.C13+studentInfoString.getStudentInfo()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void putCourse(CourseInfoString courseInfoString){
        try {
            Files.write(Paths.get(SCRSProperties.COURSE_LIST_PATH), (SCRSProperties.C13+courseInfoString.getCourseInfo()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(String id, String fileName){
        String all = SCRSProperties.EMPTY;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (br.ready()) {
                String line = br.readLine();
                String[] alreadyId = line.split(SCRSProperties.SEPARATOR);
                if(!alreadyId[0].equals(id)) all += line + SCRSProperties.C13;
            }
            FileWriter fw = new FileWriter(fileName);
            fw.write(all);
            fw.close();
            br.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public void updateStudent(String studentInfoString){
        try{
            BufferedReader br = new BufferedReader(new FileReader(SCRSProperties.STUDENT_LIST_PATH));
            String all = SCRSProperties.EMPTY;
            while (br.ready()) {
                String studentLine = br.readLine();
                String[] splitStudentLine = studentLine.split(SCRSProperties.SEPARATOR);
                if(splitStudentLine[0].equals(studentInfoString.split(SCRSProperties.SEPARATOR)[0])) all+=studentLine+SCRSProperties.SEPARATOR+SCRSProperties.C13;
                else all+=studentLine + SCRSProperties.C13;
            }
            FileWriter fw = new FileWriter(SCRSProperties.STUDENT_LIST_PATH);
            fw.write(all);
            fw.close();
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

//    private boolean checkTakePreCourse(String studentLine, String courseId) {
//        String courseLine = getLineById(courseId, SCRSProperties.COURSE_LIST_PATH);
//        return checkHavePreCourse(courseLine.split(SCRSProperties.SEPARATOR), studentLine);
//    }
//
//    private boolean checkHavePreCourse(String[] courseLineSplit, String studentLine){
//        if(courseLineSplit.length < 4) return true;
//        for (int i = 3; i < courseLineSplit.length; i++) {
//            if(!studentLine.contains(courseLineSplit[i]))
//                return false;
//        }
//        return true;
//    }

//    public String getLineById(String id, String filename){
//        try {
//            BufferedReader objStudentFile = new BufferedReader(new FileReader(filename));
//            while (objStudentFile.ready()) {
//                String line = objStudentFile.readLine();
//                String[] split = line.split(SCRSProperties.SEPARATOR);
//                if (split[0].equals(id)) return line;
//            }
//            objStudentFile.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    private boolean mathchLine(String keyword, String line) {
//        if(line.contains(keyword)) return false;
//        else return true;
//    }
//
//    public boolean matchFile(String id, String fileName){
//        try {
//            BufferedReader objStudentFile = new BufferedReader(new FileReader(fileName));
//            while (objStudentFile.ready()) {
//                String line = objStudentFile.readLine();
//                String[] alreadyId = line.split(SCRSProperties.SEPARATOR);
//                if(alreadyId[0].equals(id)){
//                    objStudentFile.close();
//                    return true;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    //    public boolean isExistCourse(String courseId, StreamObserver<StatusCode> responseObserver) {
//        try {
//            if(!match(courseId, SCRSProperties.COURSE_LIST_PATH)){
//                throw new NotExistCourseIDException();
//            }
//        } catch (NotExistCourseIDException e) {
//            StatusCode code = StatusCode.newBuilder().setStatusCode("NOTexistIDcourse").build();
//            responseObserver.onNext(code);
//            responseObserver.onCompleted();
//            return false;
//        }
//        return true;
//    }

    //    public ArrayList<String> getPreCourseListOfCourse(String courseId){
//        ArrayList<String> preCourseList = new ArrayList<>();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(SCRSProperties.COURSE_LIST_PATH));
//            while (br.ready()) {
//                String courseLine = br.readLine();
//                String[] courseLineSplit = courseLine.split(" ");
//                if(courseLineSplit[0].equals(courseId)){
//                    makePreCourseList(courseId, preCourseList, courseLineSplit);
//                    return preCourseList;
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        return preCourseList;
//    }

//    private void makePreCourseList(String courseId, ArrayList<String> preCourseList, String[] courseLineSplit) {
//        for (int j = courseLineSplit.length - 1; j > 2; j--) preCourseList.add(courseLineSplit[j]);
//    }
}
