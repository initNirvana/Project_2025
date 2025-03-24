package com.project.personal.jobchange.common.api;

import lombok.Getter;

@Getter
public enum ServiceExceptionCode {

  OUT_OF_STOCK_PRODUCT("OUT_OF_STOCK_PRODUCT", "재고가 부족합니다."),
  NOT_FOUND_POST("NOT_FOUND_POST", "포스트를 찾을 수 없습니다."),
  ;


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
