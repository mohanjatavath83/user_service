package com.aviva.user.validation.validator;

import com.aviva.user.dto.UserDto;
import com.aviva.user.validation.annotation.WebUserValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
@Component
public class WebUserValidator implements ConstraintValidator<WebUserValidation, UserDto> {

    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext context) {

        log.info("Web user validation was invoked");

        return false;
    }
}