package com.project.personal.jobchange.common.aop;

import com.project.personal.jobchange.common.api.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExceptionLoggingAspect {

  private void sendNotification(String errorMessage) {
    // TODO : 외부 로깅 시스템에 전송 로직 추가
    log.info("에러 알림 전송 : {}", errorMessage);
  }
}