package edu.miu.cs489.userprofilesms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World1";
    }

    @GetMapping("/say-hello")
    public ResponseEntity<String> sayHello2(){
        return ResponseEntity.ok("Hello World2346");
    }
}
