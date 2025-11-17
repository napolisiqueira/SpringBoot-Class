package com.spring_security.Spring_Security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @GetMapping("/users")
    public String users() {
        return "Rota Autorizada.";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Rota Autorizada.";
    }

}
