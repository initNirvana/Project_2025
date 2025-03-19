package com.project.personal.jobchange.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Around("controllerMethods()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    log.info("시작: {} 파라미터: {}", joinPoint.getSignature(), joinPoint.getArgs());

    Object result;
    try {
      result = joinPoint.proceed();
    } catch (Exception e) {
      log.error("예외 {} = {}", joinPoint.getSignature(), e.getCause() != null ? e.getCause() : "NULL");
      throw e;
    }

    long timeTaken = System.currentTimeMillis() - startTime;
    log.info("종료: {} 결과 = {} 경과 {} ms", joinPoint.getSignature(), result, timeTaken);
    return result;
  }
}