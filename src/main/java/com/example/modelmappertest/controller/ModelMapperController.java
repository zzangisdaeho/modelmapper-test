package com.example.modelmappertest.controller;

import com.example.modelmappertest.dto.Child;
import com.example.modelmappertest.dto.GrandChild;
import com.example.modelmappertest.dto.Parent;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ModelMapperController {

    private final ModelMapper modelMapper;

    @GetMapping
    public Object test(){
        List<GrandChild> grandChildren = List.of(new GrandChild("grand1", 1), new GrandChild("grand2", 2));
        List<Child> children = List.of(new Child("child1", 5, grandChildren), new Child("child2", 4, null));
        Parent parent1 = new Parent("parent1", 10, children);

        Parent copiedParent = modelMapper.map(parent1, Parent.class);

        System.out.println(copiedParent);
        System.out.println(copiedParent.getChildren().get(0).getGrandChildren().get(0).getName());

        return copiedParent;
    }
}
