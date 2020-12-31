package com.fernando.oliveira.traveler.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.fernando.oliveira.traveler";
	private static final String REQUEST_MAPPING = "/travelers/**";
	private static final String TITLE = "API de gerenciamento de viajantes";
	private static final String DESCRIPTION = "API que contém endpoints de cadastro, edição, busca e exclusão de viajantes";
	private static final String VERSION = "";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.ant(REQUEST_MAPPING))
				.build()
				.apiInfo(getApiInfo())
				.useDefaultResponseMessages(true)
				.consumes(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
				.produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE));
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.version(VERSION)
				.build();
	}
}
