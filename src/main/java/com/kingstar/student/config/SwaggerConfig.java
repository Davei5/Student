package com.kingstar.student.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
public class SwaggerConfig {
    /**
     * 配置swagger
     * @return
     */
    @Bean
    public Docket createRestApi(){
        //指定api类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                // 调用接口装载文档信息
                .apiInfo(apiInfo())
                .select()
                // 指定controller包，也可将不设置  any表示所有Controller
                .apis(RequestHandlerSelectors.basePackage("com.kingstar"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 文档信息配置
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 文档页标题
                .title("student API 文档")
                // 详细信息
                .description("用于测试和记录系统API接口")
                // 文档版本号
                .version("1.0")
                .build();
    }
}
