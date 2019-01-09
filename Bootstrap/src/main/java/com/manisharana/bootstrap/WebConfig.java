package com.manisharana.bootstrap;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/resources/application.properties")
public class WebConfig {

    /*need to be setup correctly*/
    @Bean(SpringBeans.PRODUCT_SERVICE)
    public IProductService productService(){
        return new IProductService();
    }

}
