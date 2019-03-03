package com.chrispitman.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TelemetryController {

    @PostMapping("/")
    public Telemetry echo(@RequestBody Telemetry input) {
        return input;
    }

}