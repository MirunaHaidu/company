package com.sda.company.config;

import com.sda.company.components.CustomFakerCompany;
import com.sda.company.components.CustomFakerEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomFakerCompany customFakerCompany() {
        return new CustomFakerCompany();
    }

    @Bean
    public CustomFakerEmployee customFakerEmployee(){
        return new CustomFakerEmployee();
    }
}