package com.gha.learning.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    // A simple GET request to say hello to the world ....
    @GetMapping("/hello")
    public String sayHello() {
        logger.info("Api /hello is invoked to say - Hello, World!.");
        return "Service 01 says - Hello, World!";
    }

    // A simple GET request to respond with a healthy instance message ....
    @GetMapping("/health")
    public String sayHealthy() {
        logger.info("Api /health is invoked to say - I am Healthy!.");
        return "Service 01 says - I am Healthy!";
    }


    // A simple GET request with a greetings message ....
    @GetMapping("/greetings")
    public String greetings() {
        logger.info("Api /greetings is invoked to say - Greetings from Service 1. Hope you have a wonderful day ahead..");
        return "Api /greetings is invoked to say - Greetings from Service 1. Hope you have a wonderful day ahead.";
    }

}
