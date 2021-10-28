package com.example.grpc.client;
import java.io.*;

public class SCRegisterClient {
    public static void main(String[] args) throws IOException {
        SCRegisterConsoleManager scConsole = new SCRegisterConsoleManager();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = ClientProps.EXIT_NUM+1;
        while(n!= ClientProps.EXIT_NUM){
            scConsole.getMenu();
            n = Integer.parseInt(br.readLine());
            System.out.println(ClientProps.LINE);
            switch(n){
                case 1:
                case 2://1, 2. print Student,Course
                    scConsole.printListData(n);
                    break;
                case 3://3. Add Students
                    scConsole.putStudent();
                    break;
                case 4://4. Add Courses
                    scConsole.putCourse();
                    break;
                case 5://5. Delete Student
                    scConsole.deleteStudent();
                    break;
                case 6://6. Delete Courses
                    scConsole.deleteCourse();
                    break;
                case 7://7. 수강신청
                    scConsole.updateStudentByAddCourse();
                    break;
                case 8:// 8.EXIT
                    scConsole.close();
                    return;
                default:
                    System.out.println(ClientProps.WRONG_NUM);
                    break;
            }
            System.out.println(ClientProps.LINE);
        }
    }
}





