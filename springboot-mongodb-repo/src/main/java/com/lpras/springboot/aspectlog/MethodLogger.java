/*
package com.lpras.springboot.aspectlog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodHandles;

@Aspect
@Component
public class MethodLogger {
    private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Around("applicationPackagePointcut()")
    public Object around(ProceedingJoinPoint point) */
/*throws Throwable*//*
 {
        Object result=null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        logger.info(
                "{} {} from {}",
                request.getMethod(),
                request.getRequestURI(),
                request.getRemoteAddr(),
                request.getHeader("user-id"));
        long start = System.currentTimeMillis();
        try{
            result = point.proceed();
        }catch(Throwable th){
            logger.error("Exception cought during method execution #####", th);
            //throw th;
        }finally {
            logger.info(
                    "#{}.{}(){}: {} in {}ms",
                    point.getSignature().getDeclaringType().getName(),
                    MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
                    point.getArgs(),
                    result,
                    System.currentTimeMillis() - start
            );
        }


        return result;
    }



    */
/**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     *//*

    @Pointcut("(within(com.assignment.springboot.mongo.dao.*) && @annotation(org.springframework.stereotype.Repository))"+
            " || (within(com.assignment.springboot.mongo.service.*) && @annotation(org.springframework.stereotype.Service))"+
            " || (within(com.assignment.springboot.mongo.controller.*) && @annotation(org.springframework.web.bind.annotation.RestController))")
    public void loggingPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }
    */
/**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     *//*

    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }
    @Pointcut("execution(public * *(..))"
            + " && !execution(String *.toString())"
            + " && !execution(int *.hashCode())"
            + " && !execution(boolean *.canEqual(Object))"
            + " && !execution(boolean *.equals(Object))")
    protected void publicMethod() {
    }

    */
/**
     * Pointcut that matches all Spring beans in the application's main packages.
     *//*

    @Pointcut("within(com.assignment.springboot.mongo.controller..*)"+
            " || within(com.assignment.springboot.mongo.service..*)"+
            " || within(com.assignment.springboot.mongo.dao..*)")
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

}*/
