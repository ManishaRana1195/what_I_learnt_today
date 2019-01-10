package com.manisharana.bootstrap;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@PropertySource("./src/main/resources/application.properties")
@Configuration
public class WebConfig {

    /*need to be setup correctly*/
    @Bean(SpringBeans.PRODUCT_SERVICE)
    public IProductService productService(){
        return new IProductService();
    }

}
