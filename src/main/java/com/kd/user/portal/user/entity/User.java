package com.kd.user.portal.user.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String password;

    private String nickname;

    private String comment;

}
