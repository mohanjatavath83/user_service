package com.aviva.user.dto;

import com.aviva.user.model.SourceType;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable {

  private String id;

  @NotNull(message = "firstName should not be null")
  @NotEmpty(message = "firstName should not be empty")
  private String firstName;

  private String lastName;

  @NotNull(message = "mobile should not be null")
  @NotEmpty(message = "mobile should not be empty")
  private String mobile;

  private String email;

  private SourceType sourceType;
}
