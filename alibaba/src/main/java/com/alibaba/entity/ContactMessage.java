package com.alibaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_message")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessage {
    @Id // to make column Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generates id automatically
    private Long id;

    @Column(length = 50, nullable = false)
    private String subject;
    @Column(length = 300, nullable = false)
    private String body;
    @Column(length = 50, nullable = false)
    private String email;
}
