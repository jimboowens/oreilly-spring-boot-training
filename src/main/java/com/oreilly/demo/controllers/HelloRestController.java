package com.oreilly.demo.controllers;

import com.oreilly.demo.json.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/restHello")
    public Greeting greet(@RequestParam(required = false, defaultValue = "World") String name) {
        return new Greeting("Hello, " + name + "!");
    }
}
