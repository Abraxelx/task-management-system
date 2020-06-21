package com.taskmanagement.mongo.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.Set;

@Data
@Document(collection = "Tasks")
public class Task {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String title;
    private  String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueTo;

    @DBRef
    private Set<User> userSet;

}
