package com.example.JavaDay10ex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ApiResponse {
    private String msg;
    private int error;
}
