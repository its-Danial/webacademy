package com.webacademy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class HomeController {

    @RequestMapping("/hello")
    public String getHello() {
        log.info("Said Hello");
        return "<h1>Ni Hao</h1>";
    }
}
