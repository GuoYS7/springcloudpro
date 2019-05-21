package com.offcn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name" ,length=20)
    private String name;
    @Column(name="username",length = 30,nullable = false)
    private String username;
    @Column(name = "password",length = 30,nullable = false)
    private String password;
}
