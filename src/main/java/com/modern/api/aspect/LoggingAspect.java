package com.modern.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.modern.api.security.filter..*)")
    private void logSecurityFilter() {};

    @Pointcut("execution(* com.modern.api.exception.ApiExceptionAdvisor.*(..))")
    private void logAfterException() {};

    @Around("logAfterException()")
    public Object aroundLoggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);
        log.warn("Handle Logging {}", result.toString());
        return result;
    }

    @After("logSecurityFilter()")
    public void afterFilter(JoinPoint joinPoint) {
        log.warn("After Filter Logging {}", joinPoint.getSignature());
    }

    @Before("logSecurityFilter()")
    public void beforeFilter(JoinPoint joinPoint) {
        log.warn("Before Filter Logging {}", joinPoint.getSignature());
    }

}
