package com.fernando.oliveira.traveler.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {

    @Value("${spring.data.mongodb.host}")
    private String mongodbHost;
    @Value("${spring.data.mongodb.port}")
    private String mongodbPort;
    @Value("${spring.data.mongodb.database}")
    private String mongodbDatabase;

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create("mongodb://" + mongodbHost);
    }

}
