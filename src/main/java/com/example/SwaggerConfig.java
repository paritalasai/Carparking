package com.example;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com")
public class SwaggerConfig {

    @Bean
    public Docket restfulApi() 
    {
	return new Docket(DocumentationType.SWAGGER_2).
			groupName("admin-api").select().paths(paths()).build().apiInfo(apiInfo());
    }

    private Predicate<String> paths() {
	return or(regex("/micro/.*"),regex("/car/.*"),regex("/park/.*"));
    }

    private ApiInfo apiInfo() {

	ApiInfo apiInfo = new ApiInfo("NewT", "Microservices", "1.0", "url", "Sai", "Confluence",
		"url");
	return apiInfo;
    }

}