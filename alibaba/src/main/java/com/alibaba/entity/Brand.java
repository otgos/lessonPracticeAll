package com.alibaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity //will create table which is named "brand"
@Table (name = "t_brand") //change table name from "brand" to "t_brand"
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "b_name", length = 100, nullable = false, unique = true)
    private String name;
//    @OneToMany
//    private List<Item> item;
}
