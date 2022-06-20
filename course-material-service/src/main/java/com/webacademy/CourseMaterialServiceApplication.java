package com.webacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseMaterialServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseMaterialServiceApplication.class, args);
    }
}
