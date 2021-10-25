package com.example.grpc.client;

import com.example.grpc.StudentCourseRegistrationSystemGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ServerConnection {

    private static final ServerConnection serverConnection = new ServerConnection();
    private static ManagedChannel channel;

    private ServerConnection() {
        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
    }

    public static ServerConnection getServerConnection(){
        return serverConnection;
    }

    public static StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub connect(){
        return getServerConnection().makeStub();
    }

    public ManagedChannel connectPort(){
       return channel;
    }

    public static void disconnectPort(){
        channel.shutdownNow();
    }

    public StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub makeStub(){
        return StudentCourseRegistrationSystemGrpc.newBlockingStub(connectPort());
    }
}
