package com.sistex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class App {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/pedido").allowedOrigins("http://localhost:9000");
                registry.addMapping("/item").allowedOrigins("http://localhost:9000");
                registry.addMapping("/produto").allowedOrigins("http://localhost:9000");
                
                registry.addMapping("/pedido").allowedOrigins("http://localhost:8080");
                registry.addMapping("/item").allowedOrigins("http://localhost:8080");
                registry.addMapping("/produto").allowedOrigins("http://localhost:8080");
            }
        };
    }
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
