package com.example.modelmappertest;

import lombok.Getter;

@Getter
public class BlockTest {

    private String name = "field";

    {
        name = "block";
    }

    public static void main(String[] args) {
        BlockTest blockTest = new BlockTest();
        String name = blockTest.getName();
        System.out.println("name = " + name);
    }
}
