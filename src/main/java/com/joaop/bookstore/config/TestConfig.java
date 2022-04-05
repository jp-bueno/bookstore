package com.joaop.bookstore.config;

import com.joaop.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    //indica que um método produz um bean a ser gerenciado pelo contêiner do Spring
    public void instaciaBaseDeDados() {
        this.dbService.instanciaBaseDeDados();
    }
}
