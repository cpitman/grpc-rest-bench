package com.chrispitman;

import java.io.IOException;

import com.chrispitman.grpc.TelemetryServiceGrpc;
import com.chrispitman.grpc.TelemetryServiceGrpc.TelemetryServiceBlockingStub;
import com.chrispitman.grpc.TelemetryServiceOuterClass.Telemetry;

import org.apache.http.client.ClientProtocolException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

public class GrpcBenchmark {

    @State(Scope.Benchmark)
    public static class TestState {

        TelemetryServiceBlockingStub client;
        Telemetry telemetry;

        @Setup(Level.Trial)
        public void setUp() {
            telemetry = Telemetry.newBuilder()
                .setAccountId(100)
                .setVehicleId(100)
                .setDriverId(100)
                .setLatitude(10.1f)
                .setLongitude(10.1f)
                .setBearing(256)
                .setSpeed(55)
                .setOdometer(100)
                .setFuelLevel(100)
                .setTimeReceived(1000000)
                .setTimeRecord(1000000)
                .build();

            Channel channel = ManagedChannelBuilder.forAddress("localhost", 8081).usePlaintext().build();
            client = TelemetryServiceGrpc.newBlockingStub(channel);
        }

        /**
         * @return the client
         */
        public TelemetryServiceBlockingStub getClient() {
            return client;
        }

        public Telemetry getTelemetry() {
            return telemetry;
        }

    }


    @Benchmark
    public void callService(TestState input) throws IOException, ClientProtocolException{
        input.getClient().echo(input.getTelemetry());
    }
}