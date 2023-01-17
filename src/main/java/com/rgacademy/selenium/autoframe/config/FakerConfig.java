package com.rgacademy.selenium.autoframe.config;

import com.github.javafaker.Faker;
import com.rgacademy.selenium.autoframe.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
