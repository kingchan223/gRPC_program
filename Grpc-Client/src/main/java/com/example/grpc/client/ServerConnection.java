package com.example.grpc.client;

import com.example.grpc.DataServiceGrpc;
import com.example.grpc.StudentCourseRegistrationSystemGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ServerConnection {

    private static final ServerConnection serverConnection = new ServerConnection();
    private ServerConnection() {}
    public static ServerConnection getServerConnection(){
        return serverConnection;
    }

    public static StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub connect(){
        return getServerConnection().makeStub();
    }

    public ManagedChannel connectPort(){
       return ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
    }

    public StudentCourseRegistrationSystemGrpc.StudentCourseRegistrationSystemBlockingStub makeStub(){
        return StudentCourseRegistrationSystemGrpc.newBlockingStub(connectPort());
    }

//    private static final DataConnection dataConnection = new DataConnection();
//    private DataConnection() {}
//    public static DataConnection getDataConnection(){
//        return dataConnection;
//    }
//
//    public static DataServiceGrpc.DataServiceBlockingStub connect(){
//        return getDataConnection().makeStub();
//    }
//
//    public ManagedChannel connectPort(){
//        return ManagedChannelBuilder.forAddress("localhost", 9090)
//                .usePlaintext()
//                .build();
//    }
//
//    public DataServiceGrpc.DataServiceBlockingStub makeStub(){
//        return DataServiceGrpc.newBlockingStub(connectPort());
//    }

}
