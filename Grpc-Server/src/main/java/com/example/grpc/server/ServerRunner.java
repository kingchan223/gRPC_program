package com.example.grpc.server;

import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        SCRegisterServer.run();
    }
}
