package com.paytm.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.examples.lib.HelloReply;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.MyServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;



@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


}
