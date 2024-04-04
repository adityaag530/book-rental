package com.crio.bookrental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author adityagupta
 * @date 04/04/24
 */
@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome you are authorised.";
    }
}
