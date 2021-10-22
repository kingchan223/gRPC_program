package com.example.grpc.server;


import com.example.grpc.DataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DataConnection {

    private static final DataConnection dataConnection = new DataConnection();
    private DataConnection() {}
    public static DataConnection getDataConnection(){
        return dataConnection;
    }

    public static DataServiceGrpc.DataServiceBlockingStub connect(){
        return getDataConnection().makeStub();
    }

    public ManagedChannel connectPort(){
        return ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    public DataServiceGrpc.DataServiceBlockingStub makeStub(){
        return DataServiceGrpc.newBlockingStub(connectPort());
    }

}
