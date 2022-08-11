package com.example.JavaDay10ex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Employees {
    @NotNull(message = "ID must not be null")
    @Range(min = 3,message="ID must be more than 2")
    private int ID;
    @NotNull(message = "name must not be null")
    @Size(min = 5,message="name must be more than 4")
    private String name;
    @NotNull(message = "ID must not be null")
    @Range(min =26, message = "Age must be more than 25")
    private int age;
    @AssertFalse
    private boolean OnLeave;
    @NotNull(message = "ID must not be null")
    @Range(min= 2000 , message = "invalid year")
    private int year;
    @NotNull(message = "ID must not be null")
    private int annualLeave;


}
