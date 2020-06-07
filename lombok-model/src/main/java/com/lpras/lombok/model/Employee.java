package com.lpras.lombok.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.
@Document(collection = "employee")
@Data
public class Employee {
    @Id
    private int id;
    private String name;
    private String designation;
}
