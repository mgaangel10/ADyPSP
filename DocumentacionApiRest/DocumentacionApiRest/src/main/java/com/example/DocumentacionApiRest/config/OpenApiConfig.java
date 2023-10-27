package com.example.DocumentacionApiRest.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
@Bean
    public OpenAPI openAPI (){
    return new OpenAPI().info(new Info()
                    .title("example Api").description("api rest para empleado de la empresa X")
                    .version("v0.0.1")
                    .license(new License().name("Apache 2.0").url("https://www.github.com/")))
            .externalDocs(new ExternalDocumentation().description("wiki docs")
                    .url("https://www.github.com/"));
    }

}
