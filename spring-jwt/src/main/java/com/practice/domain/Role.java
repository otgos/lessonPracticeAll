package com.practice.domain;

import com.practice.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="t_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Enumerated(EnumType.STRING) //to get the String name of Enums (ADMIN, STUDENT, USER etc)
    @Column(nullable = false)
    private UserRole name;

    @Override
    public String toString() {
        return "Role{" +
                "name=" + name +
                '}';
    }
}
