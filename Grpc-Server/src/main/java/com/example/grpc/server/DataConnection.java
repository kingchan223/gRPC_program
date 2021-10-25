package com.example.grpc.server;


import com.example.grpc.DataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DataConnection {

    private static ManagedChannel channel;

    private static final DataConnection dataConnection = new DataConnection();

    private DataConnection() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    public static DataConnection getDataConnection(){
        return dataConnection;
    }

    public static DataServiceGrpc.DataServiceBlockingStub connect(){
        return getDataConnection().makeStub();
    }

    public DataServiceGrpc.DataServiceBlockingStub makeStub(){
        return DataServiceGrpc.newBlockingStub(connectPort());
    }

    public ManagedChannel connectPort(){
        return channel;
    }

    public static void disconnectPort(){
        System.out.println("DATA CLOSE");
        channel.shutdownNow();
    }
}
