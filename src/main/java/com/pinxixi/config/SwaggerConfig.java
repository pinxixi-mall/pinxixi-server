package com.pinxixi.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger配置
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createClientApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("客户端(client)")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex("/client.*"))
                .build();
    }

    @Bean
    public Docket createAdminApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("管理后台(admin)")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex("/admin.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PinXiXi接口文档")
                .version("1.0")
                .build();
    }

}
