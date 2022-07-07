package com.example.modelmappertest.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewParent {

    private String name;

    private int age;

    private List<NewChild> children;
}
