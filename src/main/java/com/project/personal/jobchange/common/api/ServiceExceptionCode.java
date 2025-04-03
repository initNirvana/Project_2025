package com.project.personal.jobchange.common.api;

import lombok.Getter;

@Getter
public enum ServiceExceptionCode {

  RESPONSE_CREATED("RESPONSE_CREATE", "업로드에 성공했습니다."),
  RESPONSE_UPDATED("RESPONSE_UPDATE", "업데이트에 성공했습니다."),
  RESPONSE_NOT_FOUND("RESPOSNE_NOT_FOUNT", "포스트를 찾을 수 없습니다.");


  private final String code;
  private final String message;

  ServiceExceptionCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public String toString() {
    return "code : " + code + ", message : " + message;
  }
}
