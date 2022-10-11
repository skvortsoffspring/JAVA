package com.example.lab_10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private short id;
    private String name;
    private String phone;
    private String email;
}
