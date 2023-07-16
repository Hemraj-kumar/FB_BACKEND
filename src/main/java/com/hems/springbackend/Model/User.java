package com.hems.springbackend.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("signup")
@Data
public class User {
    @Id
    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private String Role;
}