package com.example.grpc.data;

import com.example.grpc.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CrudMethods {

    public ListDataResponse.Builder getAllStudentData(ListDataResponse.Builder builder){

        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(DataProps.STUDENT_LIST_PATH));
            while (objStudentFile.ready()) {
                String stuInfo = objStudentFile.readLine();
                if (!stuInfo.equals(DataProps.EMPTY))
                    builder.addData(stuInfo);
            }
            objStudentFile.close();
        } catch (IOException e) {
            builder.addData(DataProps.IOEXECEPTION_ERROR_MESSAGE);
        }
        return builder;
    }

    public ListDataResponse.Builder getAllCourseData(ListDataResponse.Builder builder){

        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(DataProps.COURSE_LIST_PATH));
            while (objStudentFile.ready()) {
                String courseInfo = objStudentFile.readLine();
                if (!courseInfo.equals(DataProps.EMPTY)) builder.addData(courseInfo);
            }
            objStudentFile.close();
        } catch (IOException e) {
            builder.addData(DataProps.IOEXECEPTION_ERROR_MESSAGE);
        }
        return builder;
    }

    public String getStudentById(String studentId) {

        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(DataProps.STUDENT_LIST_PATH));
            while (objStudentFile.ready()) {
                String line = objStudentFile.readLine();
                String[] alreadyId = line.split(DataProps.SEPARATOR);
                if (alreadyId[0].equals(studentId)) {
                    objStudentFile.close();
                    return line;
                }
            }
        }
        catch(IOException e){
            return DataProps.EMPTY;
        }
        return DataProps.EMPTY;
    }

    public String getCourseById(String courseId){
        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(DataProps.COURSE_LIST_PATH));
            while (objStudentFile.ready()) {
                String line = objStudentFile.readLine();
                String[] alreadyId = line.split(DataProps.SEPARATOR);
                if (alreadyId[0].equals(courseId)) {
                    objStudentFile.close();
                    return line;
                }
            }
        }
        catch(IOException e){
            return DataProps.EMPTY;
        }
        return DataProps.EMPTY;
    }

    public void putStudent(StudentInfoString studentInfoString) throws IOException {
        Files.write(Paths.get(DataProps.STUDENT_LIST_PATH),
                (DataProps.C13+studentInfoString.getStudentInfo()).getBytes(), StandardOpenOption.APPEND);
    }

    public void putCourse(CourseInfoString courseInfoString) throws IOException {
        Files.write(Paths.get(DataProps.COURSE_LIST_PATH), (DataProps.C13+courseInfoString.getCourseInfo()).getBytes(), StandardOpenOption.APPEND);

    }

    public void deleteById(String id, String fileName) throws IOException {
        String all = DataProps.EMPTY;

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            String line = br.readLine();
            String[] alreadyId = line.split(DataProps.SEPARATOR);
            if(!alreadyId[0].equals(id)) all += line + DataProps.C13;
        }
        FileWriter fw = new FileWriter(fileName);
        fw.write(all);
        fw.close();
        br.close();

    }

    public void updateStudent(String studentInfoString) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(DataProps.STUDENT_LIST_PATH));
        String all = DataProps.EMPTY;
        String stdId = studentInfoString.split(DataProps.SEPARATOR)[0];
        while (br.ready()) {
            String studentLine = br.readLine();
            String[] studentLineSplit = studentLine.split(DataProps.SEPARATOR);
            if(studentLineSplit[0].equals(stdId)) all+=studentInfoString+ DataProps.C13;
            else all+=studentLine + DataProps.C13;
        }
        FileWriter fw = new FileWriter(DataProps.STUDENT_LIST_PATH);
        fw.write(all);
        fw.close();
        br.close();

    }
}
