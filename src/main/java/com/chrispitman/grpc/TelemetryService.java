package com.chrispitman.grpc;

import com.chrispitman.grpc.TelemetryServiceOuterClass.Telemetry;

import io.grpc.stub.StreamObserver;

public class TelemetryService extends TelemetryServiceGrpc.TelemetryServiceImplBase {
    @Override
    public void echo(Telemetry request, StreamObserver<Telemetry> responseObserver) {
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }
}