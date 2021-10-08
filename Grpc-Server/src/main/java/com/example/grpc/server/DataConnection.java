package com.example.grpc.server;

import com.example.grpc.DataRequest;
import com.example.grpc.DataResponse;
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

    public DataSourceGrpc.DataSourceBlockingStub makeStub(){
        return DataSourceGrpc.newBlockingStub(connect());
    }

}
