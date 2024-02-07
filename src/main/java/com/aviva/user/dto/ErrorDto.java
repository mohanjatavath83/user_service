package com.aviva.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
  private String object;

  private String field;

  private Object rejectedValue;
  private String message;

  public ErrorDto(String field, String message, Object rejectedValue) {
    this.field = field;
    this.message = message;
    this.rejectedValue = rejectedValue;
  }
}
