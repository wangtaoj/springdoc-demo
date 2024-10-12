package com.wangtao.springdoc.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

/**
 * @author wangtao
 * Created at 2023-09-10
 */
@Configuration(proxyBeanMethods = false)
public class SpringdocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("springdoc-openapi示例")
                .version("1.0")
                .description("springdoc-openapi示例")
                .termsOfService("wangtaoj.github.io")
                .license(new License().name("Apache 2.0").url("wangtaoj.github.io"))
            ).addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
            .components(new Components().addSecuritySchemes(
                HttpHeaders.AUTHORIZATION,
                new SecurityScheme().name(HttpHeaders.AUTHORIZATION).type(SecurityScheme.Type.HTTP).scheme("bearer")
            ));
    }

    /**
     * javadoc api分组
     */
    @Bean
    public GroupedOpenApi javadocApi() {
        return GroupedOpenApi.builder().group("javadoc api模块")
            // 扫描的包
            .packagesToScan("com.wangtao.springdoc.controller.javadoc")
            // 匹配的请求路径
            .pathsToMatch("/**")
            .build();
    }

    /**
     * swagger注解 api分组
     */
    @Bean
    public GroupedOpenApi swaggerAnnotationApi() {
        return GroupedOpenApi.builder().group("swagger注解 api模块")
            .packagesToScan("com.wangtao.springdoc.controller.swagger")
            .pathsToMatch("/**")
            .build();
    }
}
