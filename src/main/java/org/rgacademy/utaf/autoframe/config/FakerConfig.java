package org.rgacademy.utaf.autoframe.config;

import com.github.javafaker.Faker;
import org.rgacademy.utaf.autoframe.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
