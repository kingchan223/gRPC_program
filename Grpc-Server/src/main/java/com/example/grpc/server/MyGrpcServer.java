package com.example.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MyGrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int fort = 8080;
        Server server = ServerBuilder.forPort(fort)
                .addService(new StudentCourseRegistrationSystemImpl())
                .build();

        server.start();
        System.out.println("Listening <"+fort+">.......");
        server.awaitTermination();
    }
}
