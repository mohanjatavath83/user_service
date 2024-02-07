package com.aviva.user.controller;

import com.aviva.user.dto.ResponseDto;
import com.aviva.user.dto.UserDto;
import com.aviva.user.facade.UserFacade;
import com.aviva.user.validation.UserValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserFacade userFacade;

  private final UserValidator validator;

  private final ObjectMapper objectMapper;

  @PostMapping("/v1")
  public ResponseDto createUserV1(@Valid @RequestBody UserDto userDto) throws Exception {
    log.info("request we receive {} ", objectMapper.writeValueAsString(userDto));
    return new ResponseDto(HttpStatus.CREATED.name(), HttpStatus.CREATED.value(), userDto);
  }

  @PostMapping("/v2")
  public ResponseEntity<String> createUserV2(@RequestBody UserDto userDto) {

    Set<String> voilations = validator.validate(userDto);
    if (!voilations.isEmpty()) {
      return ResponseEntity.badRequest().body(String.join("|", voilations));
    }

    return ResponseEntity.ok().body("success");
  }

  @PostMapping("/v3")
  public ResponseEntity<String> createUserV3(@RequestBody UserDto userDto) {

    Set<String> voilations = validator.validateV2(userDto);
    if (!voilations.isEmpty()) {
      return ResponseEntity.badRequest().body(String.join("|", voilations));
    }

    return ResponseEntity.ok().body("success");
  }
}
