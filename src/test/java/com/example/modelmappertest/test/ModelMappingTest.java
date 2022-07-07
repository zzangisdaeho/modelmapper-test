package com.example.modelmappertest.test;

import com.example.modelmappertest.classes.Child;
import com.example.modelmappertest.classes.GrandChild;
import com.example.modelmappertest.classes.NewParent;
import com.example.modelmappertest.classes.Parent;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

public class ModelMappingTest {

    private ModelMapper modelMapper = new ModelMapper();

    {
        System.out.println("초기화 블럭 호출");
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldAccessLevel(PRIVATE)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);
    }

    @Test
    void mapperTest(){
        List<GrandChild> grandChildren = List.of(new GrandChild("grand1", 1), new GrandChild("grand2", 2));
        List<Child> children = List.of(new Child("child1", 5, grandChildren), new Child("child2", 4, null));
        Parent parent1 = new Parent("parent1", 10, children);

        Parent newParent = modelMapper.map(parent1, Parent.class);

        System.out.println(newParent);
        System.out.println(newParent.getChildren().get(0).getGrandChildren().get(0).getName());
    }

    @Test
    void mapperTest2(){
        List<GrandChild> grandChildren = List.of(new GrandChild("grand1", 1), new GrandChild("grand2", 2));
        List<Child> children = List.of(new Child("child1", 5, grandChildren), new Child("child2", 4, null));
        Parent parent = new Parent("parent1", 10, children);

        NewParent newParent = modelMapper.map(parent, NewParent.class);

        System.out.println(newParent);
        System.out.println(newParent.getChildren().get(0).getGrandChildren().get(0).getName());
    }

}
