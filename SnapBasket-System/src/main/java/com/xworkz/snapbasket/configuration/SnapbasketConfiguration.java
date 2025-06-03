package com.xworkz.snapbasket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
@ComponentScan(basePackages = "com.xworkz")
public class SnapbasketConfiguration {
  @Bean
   public ViewResolver viewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }
}
