package com.github.core.controller;

import com.github.model.enums.AuthResourceEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResourceController {

    @GetMapping("/auth-resources")
    public AuthResourceEnum[] authResources(){
        AuthResourceEnum[] values = AuthResourceEnum.values();
        return values;
    }

}
