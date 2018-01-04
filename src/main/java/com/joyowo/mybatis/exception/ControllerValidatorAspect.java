package com.joyowo.mybatis.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Author: chenby
 * Date: 2018-01-02
 */
@Aspect
@Component
public class ControllerValidatorAspect {

    @Pointcut("execution(* com.joyowo.mybatis.controller.*.*(..)) && args(..,bindingResult)")
    public void pointCut(BindingResult bindingResult) {
    }

    @Around("pointCut(bindingResult)")
    public Object validate(ProceedingJoinPoint joinPoint, BindingResult bindingResult) throws Throwable {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getFieldErrors().forEach(fieldError ->
                    sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage())
            );
            System.out.println(sb);
            throw new RuntimeException();
        }
        return joinPoint.proceed();
    }
}
