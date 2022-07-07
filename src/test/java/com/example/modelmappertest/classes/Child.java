package com.example.modelmappertest.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
public class Child {

    private String name;

    private int age;

    private List<GrandChild> grandChildren;

//    public Child(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
}
