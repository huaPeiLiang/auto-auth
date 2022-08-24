package com.github.core.service.impl;

import com.github.model.enums.AuthResourceEnum;
import org.springframework.stereotype.Service;

@Service
public class AuthResourceHandler implements com.github.core.service.AuthResourceHandler {

    @Override
    public boolean allowOperationCheck(AuthResourceEnum[] authResourceEnums) {
        return true;
    }

}
