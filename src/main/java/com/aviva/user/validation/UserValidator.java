package com.aviva.user.validation;

import com.aviva.user.dto.UserDto;
import com.aviva.user.model.SourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserValidator<T> {

    /*private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();*/

    private final Validator validator;


    public Set<String> validate(T userDto) {

        Set<ConstraintViolation<T>> voilations = validator.validate(userDto);
        if (!voilations.isEmpty()) {
            return voilations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
        }

        return Collections.EMPTY_SET;

    }

    public Set<String> validateV2(UserDto userDto) {

        Set<ConstraintViolation<UserDto>> voilations;
        if (SourceType.WEB.equals(userDto.getSourceType())) {
            voilations = validator.validate(userDto, Default.class);
        } else {
            voilations = validator.validate(userDto, Default.class);
        }


        return voilations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());

    }
}
