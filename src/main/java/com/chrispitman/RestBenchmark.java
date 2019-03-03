package com.chrispitman;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

public class RestBenchmark {

    @State(Scope.Benchmark)
    public static class TestState {
        HttpPost request;
        CloseableHttpClient client;

        @Setup(Level.Trial)
        public void setUp() {
            client = HttpClients.createDefault();
            request = new HttpPost("http://localhost:8080/");
            
            StringEntity requestEntity = new StringEntity("{\"timeRecorded\": 100000,\"timeReceived\": 100000,\"latitude\": 10.1,\"longitude\": 10.1,\"bearing\": 100,\"odometer\": 100,\"speed\": 100,\"fuelLevel\": 100,\"accountId\": 100,\"vehicleId\": 100,\"driverId\": 100}", ContentType.APPLICATION_JSON);
            request.setEntity(requestEntity);
        }

        public HttpPost getRequest() {
            return request;
        }

        public CloseableHttpClient getClient() {
            return client;
        }

    }


    @Benchmark
    public void callService(TestState input) throws IOException, ClientProtocolException{
        input.getClient().execute(input.getRequest()).close();;
    }
}