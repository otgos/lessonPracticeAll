package com.alibaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_category") //table name is given
@Entity //Entity annotation converts out class to table
@Getter  //er do not need getter method in our project.Lombok @Getter will do this
@Setter
@AllArgsConstructor //All argument constructor
@NoArgsConstructor //No Argument/empty constructor
public class Category {
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; //auto generated

    private String name;


}
