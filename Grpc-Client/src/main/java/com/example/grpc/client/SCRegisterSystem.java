package com.example.grpc.client;


import com.example.grpc.StudentCourseRegistrationSystemGrpc;
import io.grpc.ManagedChannel;
import java.io.*;

public class SCRegisterSystem {
    public static void main(String[] args) throws IOException {
        StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub stub = ServerConnection.getServerConnection().connect();
        SCRegisterMethods scMethods = new SCRegisterMethods();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = ClientProperties.EXIT_NUM+1;
        while(n!=ClientProperties.EXIT_NUM){
            scMethods.getMenu(stub);
            n = Integer.parseInt(br.readLine());
            System.out.println(ClientProperties.LINE);
            switch(n){
                case 1:
                case 2:
                    scMethods.printListData(stub, n);
                    break;
                case 3://3. Add Students
                    scMethods.putStudent(stub);
                    break;
                case 4://4. Add Courses
                    scMethods.putCourse(stub);
                    break;
                case 5://5. Delete Student
                    scMethods.deleteStudent(stub);
                    break;
                case 6://6. Delete Courses
                    scMethods.deleteCourse(stub);
                    break;
                case 7://7. 수강신청
                    scMethods.updateStudentByAddCourse(stub);
                    break;
                case 8:// 8.EXIT
                    System.out.println(ClientProperties.EXIT);
                    return;
                default:
                    System.out.println(ClientProperties.WRONG_NUM);
                    break;
            }
            System.out.println(ClientProperties.LINE);
        }
    }
}
