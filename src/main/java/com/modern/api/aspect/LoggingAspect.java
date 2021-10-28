package com.modern.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.modern.api.exception.ApiExceptionAdvisor.*(..))")
    private void logAfterException() {};

    @Around("logAfterException()")
    public Object aroundLoggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);
        log.warn("Handle Logging {}", result.toString());
        return result;
    }

}
