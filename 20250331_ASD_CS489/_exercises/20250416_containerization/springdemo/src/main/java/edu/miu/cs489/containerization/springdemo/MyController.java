package edu.miu.cs489.containerization.springdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class MyController {

    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello world!");
    }
}
