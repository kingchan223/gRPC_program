package com.example.grpc.data;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MyGrpcData {
    public static void main(String[] args) throws IOException, InterruptedException {
        int fort = 9090;
        Server server = ServerBuilder.forPort(fort)
                .addService(new DataSourceImpl())
                .build();
        server.start();
        System.out.println("Listening <"+fort+">.......");
        server.awaitTermination();
    }
}
