package com.github.core.service;

import com.github.model.enums.AuthResourceEnum;

public interface AuthResourceHandler {

    boolean allowOperationCheck(AuthResourceEnum[] authResourceEnums);
}
