package it.springmvc.dev.webtracker.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* it.springmcv.dev.webtracker.controller.*.*(..))")
    private void forControllerPackage () {}

    @Pointcut("execution(* it.springmcv.dev.webtracker.service.*.*(..))")
    private void forServicePackage () {}

    @Pointcut("execution(* it.springmcv.dev.webtracker.dao.*.*(..))")
    private void forDaoPackage () {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow () {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinpoint) {
        // display method we are calling
        String theMethod = joinpoint.getSignature().toShortString();
        myLogger.info("=====> in @Before: calling method: " + theMethod);
        // display the arguments to the method

        //get the arguments
        Object [] args = joinpoint.getArgs();
        for (Object tempArg: args)
            myLogger.info("====> argument: " + tempArg);
    }

    //add @Before advice

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()",returning = "result")
    public void afterReturning (JoinPoint joinPoint, Object result) {
        // display method we are returning from
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("=====> in @AfterReturning: calling method: " + theMethod);
        // display data returned
        myLogger.info("====> result: " + result);
    }
}
