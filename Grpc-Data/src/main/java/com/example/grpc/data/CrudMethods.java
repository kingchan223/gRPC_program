package com.example.grpc.data;

import com.example.grpc.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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

    public boolean deleteById(String id, String fileName){
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
            String stdId = studentInfoString.split(SCRSProperties.SEPARATOR)[0];
            while (br.ready()) {
                String studentLine = br.readLine();
                String[] studentLineSplit = studentLine.split(SCRSProperties.SEPARATOR);
                if(studentLineSplit[0].equals(stdId)) all+=studentInfoString+SCRSProperties.C13;
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
}
