package com.github.core.aop;

import com.github.core.interfaces.AuthResource;
import com.github.core.service.AuthResourceHandler;
import com.github.model.enums.AuthResourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 切面配置 调用方法前初始化域的配置信息
 */
@Component
@Aspect
@Slf4j
public class AuthResourceAspect {

    @Resource
    private AuthResourceHandler authResourceHandler;

    /**
     * 切入点
     */
    @Pointcut(value = "@annotation(com.github.core.interfaces.AuthResource)")
    private void pointCut() {
    }

    /**
     * 调用方法前执行 根据选中配置及租户id进行初始化
     * @param joinPoint  joinPoint
     * @param authResource authResource
     */
    @Before("pointCut() && @annotation(authResource)")
    public void beforeLog(JoinPoint joinPoint, AuthResource authResource) {
        // 获取类名
        String name = joinPoint.getSignature().getClass().getName();
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 判断是否有操作权限
        AuthResourceEnum[] authResourceEnums = authResource.value();
        if (null == authResourceEnums){
            throw new RuntimeException("没有权限");
        }
        if (!authResourceHandler.allowOperationCheck(authResourceEnums)){
            throw new RuntimeException("没有权限");
        }
    }
}
