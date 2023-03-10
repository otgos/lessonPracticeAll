package com.tpe.domain;

import com.tpe.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING) //brings the enums as string name (ADMIN, STUDENT, not ordinal value
    @Column(length = 30, nullable = false)
    private UserRole name;

    //get toString but bring only the name
    @Override
    public String toString() {
        return "Role{" +
                "name=" + name +
                '}';
    }
}
