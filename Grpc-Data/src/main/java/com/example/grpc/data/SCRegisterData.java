package com.example.grpc.data;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SCRegisterData {

    public static Server server;

    private SCRegisterData() {}

    public static void closeData(){
        System.out.println("Data service를 종료합니다.");
        server.shutdownNow();
    }

    public static void run() throws IOException, InterruptedException {
        int fort = 9090;
        server = ServerBuilder.forPort(fort)
                .addService(new SCRegisterSystemDataImpl())
                .build();
        server.start();
        System.out.println("Listening <"+fort+">.......");
        server.awaitTermination();
    }
//    public static void main(String[] args) throws IOException, InterruptedException {
//        int fort = 9090;
//        Server server = ServerBuilder.forPort(fort)
//                .addService(new SCRegisterSystemDataImpl())
//                .build();
//        server.start();
//        System.out.println("Listening <"+fort+">.......");
//        server.awaitTermination();
//    }
}
