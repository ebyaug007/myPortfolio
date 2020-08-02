package com.blog.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(schema = "schema1")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;


}
