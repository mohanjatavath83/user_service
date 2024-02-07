package com.aviva.user.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserModel implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private SourceType source;
}
