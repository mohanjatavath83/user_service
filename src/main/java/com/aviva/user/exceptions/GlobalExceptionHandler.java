package com.aviva.user.exceptions;

import com.aviva.user.dto.ErrorDto;
import com.aviva.user.dto.ResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ResponseDto<List<ErrorDto>> validationExceptions(MethodArgumentNotValidException ex) {
    List<ErrorDto> errors = new ArrayList<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              String fieldName = ((FieldError) error).getField();
              String errorMessage = error.getDefaultMessage();
              Object rejectedValue = ((FieldError) error).getRejectedValue();
              errors.add(new ErrorDto(fieldName, errorMessage, rejectedValue));
            });

    return new ResponseDto(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), errors);
  }
}
