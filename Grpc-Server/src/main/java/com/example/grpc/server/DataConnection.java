package com.example.grpc.server;

import com.example.grpc.DataRequest;
import com.example.grpc.DataResponse;
import com.example.grpc.DataServiceGrpc;
import com.example.grpc.DataSourceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DataConnection {

    public ManagedChannel connect(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        return channel;
    }

    public DataServiceGrpc.DataServiceBlockingStub makeStub(){
        return DataServiceGrpc.newBlockingStub(connect());
    }

}
