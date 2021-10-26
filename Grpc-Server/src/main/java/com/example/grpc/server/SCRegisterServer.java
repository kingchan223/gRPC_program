package com.example.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SCRegisterServer {

    public static Server server;

    private SCRegisterServer() {}

    public static void closeServer(){
        System.out.println("Server service를 종료합니다.");
        server.shutdownNow();
    }

    public static void run() throws IOException, InterruptedException {
        int fort = 8080;
        server = ServerBuilder.forPort(fort)
                .addService(new SCRegistrationSystemServerImpl())
                .build();
        server.start();
        System.out.println("Listening <"+fort+">.......");
        server.awaitTermination();
    }
}
