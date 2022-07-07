package com.example.modelmappertest.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldAccessLevel(PRIVATE)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);

        modelMapper.addConverter((context) -> ZonedDateTime.of(context.getSource(), ZoneOffset.UTC), LocalDateTime.class, ZonedDateTime.class);
        modelMapper.addConverter((context) -> context.getSource().toLocalDateTime(), ZonedDateTime.class, LocalDateTime.class);

        return modelMapper;
    }

    @Bean
    public ObjectMapper registryObjectMapper(){
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
