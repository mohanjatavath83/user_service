package com.aviva.user.facade.impl;

import com.aviva.user.dto.UserDto;
import com.aviva.user.facade.UserFacade;
import com.aviva.user.model.UserModel;
import com.aviva.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacadeImpl implements UserFacade {

    private final ObjectMapper objectMapper;
    private final UserService userService;

    public UserDto createUser(UserDto userDto) {
        UserModel user = userService.createUser(objectMapper.convertValue(userDto, UserModel.class));
        userDto = objectMapper.convertValue(user, UserDto.class);

        return userDto;
    }
}
