package com.example.modelmappertest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Parent {

    private String name;

    private int age;

    private List<Child> children;

//    public Parent(String name, int age, List<Child> children) {
//        this.name = name;
//        this.age = age;
//        this.children = children;
//    }
}
