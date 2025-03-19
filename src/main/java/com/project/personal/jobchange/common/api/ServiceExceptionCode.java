package com.project.personal.jobchange.common.api;

import lombok.Getter;

@Getter
public enum ServiceExceptionCode {

  OUT_OF_STOCK_PRODUCT("OUT_OF_STOCK_PRODUCT", "재고가 부족합니다."),
  NOT_FOUND_ORDER("NOT_FOUND_ORDER", "주문 내역을 찾을 수 없습니다."),
  NOT_FOUND_PRODUCT("NOT_FOUND_PRODUCT", "상품을 찾을 수 없습니다."),
  NOT_FOUND_USER("NOT_FOUND_USER", "사용자를 찾을 수 없습니다."),
  NOT_FOUND_CATEGORY("NOT_FOUND_CATEGORY", "카테고리를 찾을 수 없습니다."),
  NOT_FOUND_REFUND("NOT_FOUND_REFUND", "환불 요청건을 찾을 수 없습니다."),
  NOT_FOUND_ORDER_ITEM("NOT_FOUND_ORDER_ITEM", "주문의 상품을 찾을 수 없습니다."),
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
