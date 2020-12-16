package com.paytm.server;

import io.grpc.ServerBuilder;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Component
public class ServerBuilderConfigurer implements GrpcServerConfigurer {
  public static final int NEW_MAX_MESSAGE_SIZE = 100 * 1024 * 1024; // 100MB

  public static final Executor executor = Executors.newFixedThreadPool(100);

  @Override
  public void accept(ServerBuilder<?> serverBuilder) {
    serverBuilder.maxInboundMessageSize(NEW_MAX_MESSAGE_SIZE);
    serverBuilder.executor(executor);
  }

  @Override
  public GrpcServerConfigurer andThen(Consumer<? super ServerBuilder<?>> after) {
    return null;
  }
}