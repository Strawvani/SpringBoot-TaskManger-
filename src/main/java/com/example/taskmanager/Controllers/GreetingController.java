package com.example.taskmanager.Controllers;

import com.example.taskmanager.Services.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/greeting")
@RestController
public class GreetingController {

    private final GreetingService greetingService;


    public GreetingController (GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> greet(@PathVariable String name){
        return ResponseEntity.ok(greetingService.greet(name));
    }
}
