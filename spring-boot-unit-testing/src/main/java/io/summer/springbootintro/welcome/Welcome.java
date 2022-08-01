package io.summer.springbootintro.welcome;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    
    @RequestMapping("/")
    public String sayWelcome() {
        return "Welcome to Spring Boot Unit Testing with JUnit 5";
    }
}
