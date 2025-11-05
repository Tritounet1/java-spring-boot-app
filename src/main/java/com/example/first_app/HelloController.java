package com.example.first_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Default Route
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    // Get Route with Query Parameters
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello " + name;
    }

    // Get Route with Path Variables
    @GetMapping("/hello")
    public String getResource(@RequestParam String name) {
        return "Hello " + name;
    }

    // Post Route with Request Body
    @PostMapping("/hello")
    public String createResource(@RequestBody User user) {
        return "Hello " + user.getName();
    }
}
