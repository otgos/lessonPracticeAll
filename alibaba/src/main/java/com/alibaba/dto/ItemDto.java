package com.alibaba.dto;


import com.alibaba.entity.Brand;
import com.alibaba.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
        DTO stands for Data Transfer Object
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {



    private String name;

    private double price;

    private String description;

    private Long brandId;

    private Long categoryId;

    private String size;

    private String color;

}
