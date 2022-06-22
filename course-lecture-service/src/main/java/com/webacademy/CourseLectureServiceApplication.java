package com.webacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseLectureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseLectureServiceApplication.class, args);
    }
}
