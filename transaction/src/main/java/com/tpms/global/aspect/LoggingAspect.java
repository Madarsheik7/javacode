

package com.tpms.global.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.tpms.global..*(..)) && !execution(* com.tpms.global.constants..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.debug("Start of method: {}", methodName);

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        if (result instanceof CompletableFuture) {
            ((CompletableFuture<?>) result).whenComplete((res, ex) -> {
                long endTime = System.currentTimeMillis();
                logger.debug("End of method: {}. Time taken: {} ms", methodName, (endTime - startTime));
            });
        } else {
            long endTime = System.currentTimeMillis();
            logger.debug("End of method: {}. Time taken: {} ms", methodName, (endTime - startTime));
        }
        return result;
    }
}