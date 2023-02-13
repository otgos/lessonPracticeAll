package com.tpe.dto;

import com.tpe.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message="enter first name")
    private String firstName;

    @NotBlank(message="enter last name")
    private String lastName;

    @NotBlank(message="enter user name")
    @Size(min=5, max=10, message="Please provide a user name min 5, max=10 chars long")
    private String userName;

    @NotBlank(message="enter password")
    private String password;

}
