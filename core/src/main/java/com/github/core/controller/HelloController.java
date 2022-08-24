package com.github.core.controller;

import com.github.core.interfaces.AuthResource;
import com.github.model.enums.AuthResourceEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @AuthResource(AuthResourceEnum.ACCOUNT_READ)
    public String sayHello(){
        return "martin";
    }
}
