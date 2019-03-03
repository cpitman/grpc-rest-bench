package com.chrispitman.grpc;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.grpc.ServerBuilder;

@Component
@Scope(value="singleton")
public class Server {
    private static final Logger logger = LogManager.getLogger();
    private io.grpc.Server server;

    @PostConstruct
    public void start() throws IOException {
        server = ServerBuilder.forPort(8081).addService(new TelemetryService()).build();
        server.start();

        logger.info("Grpc Server Started on 8081");
    }

    @PreDestroy
    public void stop() {
        logger.info("Grpc Server Shutting Down");
        server.shutdown();
    }
}