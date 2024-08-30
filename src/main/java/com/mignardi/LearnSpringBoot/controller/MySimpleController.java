package com.mignardi.LearnSpringBoot.controller;

import com.mignardi.LearnSpringBoot.Calculator;
import org.springframework.web.bind.annotation.*;

@RestController
public class MySimpleController {

    // Field Injection
//    @Autowired
//    private Calculator calculator;

    // Constructor Injection
    private final Calculator calculator;
    public MySimpleController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "Hello World";
    }

    @GetMapping("/test")
    public String home2() {
        return "Hello World 2";
    }

    @GetMapping("/sum{a}{b}")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.sum(a, b);
    }
}
