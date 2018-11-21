package com.example.sbhi.utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectLoggers {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectLoggers.class);

    /**
     * Method to log statement before starting any method.
     * 
     * @return join Point
     */
    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping) "
            + "&& execution(public * *(..))")

    public Object beforeMethod(final JoinPoint joinPoint) {
        LOGGER.debug(" {} - Entered method", joinPoint.getSignature().getName());
        return joinPoint;
    }

    /**
     * Method to log statement before exiting any method.
     * 
     * @return join Point
     */
    @After("@annotation(org.springframework.web.bind.annotation.RequestMapping) "
            + "&& execution(public * *(..))")

    public Object afterMethod(final JoinPoint joinPoint) {
        LOGGER.debug(" {} - Exiting method", joinPoint.getSignature().getName());
        return joinPoint;
    }

    /**
     * Method to log the return value for any public method.
     * 
     * @return join Point
     */
    @AfterReturning(pointcut = "@annotation(org.springframework.web.bind.annotation.RequestMapping)"
            + "&& execution(public * *(..))", returning = "result")

    public Object returnValue(final JoinPoint joinPoint, final Object result) {
        LOGGER.debug(" {} - Method returns {}.", joinPoint.getSignature().getName(), result);

        return joinPoint;
    }

    /**
     * Method to log statement before starting any method. in Service Implementation
     * 
     * @return join Point
     */
    @Before("execution(* com.example.sbhi.dao.PersonDAO.*(..))")

    public Object beforeMethodChgReqServicet(final JoinPoint joinPoint) {
        return beforeMethod(joinPoint);
    }
}