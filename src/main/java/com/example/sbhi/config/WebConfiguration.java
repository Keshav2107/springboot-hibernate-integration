package com.example.sbhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).favorParameter(true).parameterName("mediaType")
                .ignoreAcceptHeader(false).useJaf(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Creating swagger object.
     * 
     * @return Docket object
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.example.sbhi"))
                .build().pathMapping("/").apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Keshav Goyal", "Need to Update wiki page here",
                "goyal.keshav2107@gmail.com");

        return new ApiInfoBuilder().contact(contact).title("Spring hibernate integration")
                .description("A RESTful API for creating and deleting person")
                .version("v1.0").build();
    }

}
