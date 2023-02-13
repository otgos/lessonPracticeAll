package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor // ID will be also set in constructor
@NoArgsConstructor
//@RequiredArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "firstName cannot be null")
    @NotBlank(message = "firstName cannot be white space")
    @Size(min=2, max=25, message="First name '${validatedValue} must be between {min} and {max} long")
    @Column (nullable = false, length = 25) //from hibernate, it will be checked in
    // repo layer, validator will be checked in controller layer... it is double check
    /*final*/ private String name;
    @Column (nullable = false, length = 25)
    /*final*/ private String lastName;
    /*final*/ private Integer grade;
    @Column (nullable = false, length = 50, unique = true)
    @Email(message = "provide valid email")
    /*final*/ private String email;
    /*final*/ private String phoneNumber;
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdDate = LocalDateTime.now();

    @OneToMany(mappedBy = "student")
    private List<Book> books = new ArrayList<>();

    @JoinColumn(name="user_id")
    @OneToOne
    private User user;


}
