package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    @Profile("!prd")
    fun apiDev(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiEndPointsInfo())
            .groupName("api/v1")
            .securityContexts(securityContext())
            .securitySchemes(apiKey())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
    }

    @Bean
    @Profile("prd")
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiEndPointsInfo())
            .enable(false)
            .groupName("api/v1")
            .securityContexts(securityContext())
            .securitySchemes(apiKey())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
    }

    private fun apiEndPointsInfo(): ApiInfo {
        return ApiInfoBuilder().title("Demo Api").description("Demo Api").version("v1").build()
    }

    private fun apiKey(): List<SecurityScheme> {
        val key = ApiKey("JWT", "Authorization", "header")

        return object: ArrayList<SecurityScheme>() {
            init {
                add(key)
            }
        }
    }

    private fun securityContext(): List<SecurityContext> {
        val context = SecurityContext.builder().securityReferences(defaultAuth())
            .build()

        return object: ArrayList<SecurityContext>() {
            init {
                add(context)
            }
        }
    }

    fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope

        return object : ArrayList<SecurityReference>() {
            init {
                add(SecurityReference("JWT", authorizationScopes))
            }
        }
    }
}