package com.alibaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    Note: When we join tables we have to decide what kind of relation will be there.
    There are 4 types relations
        1. On-To-One (ex: One person to Passport)
        2. Many-To-One (Ex: Many Items to One Brand)
        3. One -To-Many
        4. Many-To-Many (One student likes many course, many student canlike the same course)
 */

@Entity //will create table which is named "item"
@Table(name = "t_item") //change table name from "item" to "t_item"
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_name", nullable = false, length = 200)
    private String name; //trauser

    private double price; //50

    private String description; //cotton....

    @ManyToOne // in our Item Table it will create new column and its default name will be brand_id
    //@JoinColumn(name="b_id") //JoinColumn allows us to set name for foreign key column
    private Brand brand; //brand_id

    @ManyToOne // by default it will create column named as "category_id"
    @JoinColumn(name="cat_id")
    private Category category;

    private String size;
    private String color;

}
