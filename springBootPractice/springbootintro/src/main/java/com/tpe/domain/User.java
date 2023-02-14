package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="t_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25, nullable = false)
    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 25, nullable = false, unique = true) //unique name should be unique
    private String userName;
    @Column(length = 255, nullable = false) //password will be encoded so the size may increase...
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)  // when i call users, i also want to see its roles..
    @JoinTable(name="t_user_role",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns =  @JoinColumn(name="role_id"))
    //make list and ask what is the issue, then set to SET
    private Set<Role> roles = new HashSet<>();


    //what should be user and student relation...?

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Student student;

}
