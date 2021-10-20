package com.fernando.oliveira.traveler.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
public class TravelerControllerIntegrationTest {

    private WireMockServer wireMockServer;

//    @Value(value="integration.test.wiremock.port")
//    private Integer port;

//    @Autowired
//    private MockMvc mockMvc;

//    @BeforeEach
//    void setUp(){
//        wireMockServer = new WireMockServer(port);
//        configureFor(port);
//        wireMockServer.start();
//    }
//    void afterEach(){
//        this.wireMockServer.stop();
//    }


    private static final String TRAVELER_MAPPING = "v1/travelers";

//    @Test
    void givenValidRequestThenCreateTravelerThenReturnTravelerDetails(){

    }

}
