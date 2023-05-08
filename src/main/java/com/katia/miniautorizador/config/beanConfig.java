package com.katia.miniautorizador.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class beanConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
