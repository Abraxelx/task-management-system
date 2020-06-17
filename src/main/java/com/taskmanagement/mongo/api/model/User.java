package com.taskmanagement.mongo.api.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@ToString
@Document(collection = "Users")
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
