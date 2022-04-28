package com.micro.departmentservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.micro.departmentservice"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MICROSERVICE1 API",
                "Department Service.",
                "Version 1.0",
                "Terms of service is not available by  now",
                "Ruhimbazab@gmail.com","Not Available","Not Available");
    }
}
