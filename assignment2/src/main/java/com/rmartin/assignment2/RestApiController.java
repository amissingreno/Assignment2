package com.rmartin.assignment2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robby Martin
 */
@RestController
public class RestApiController {

    @GetMapping("/simpleGreeting")
    public String simpleGreeting(){
        return "Hello, there!";
    }
    
}
