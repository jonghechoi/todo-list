package com.example.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Cors {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") // 허용할 오리진을 지정
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드를 지정
                        .allowCredentials(true) // 쿠키를 주고받을 수 있도록 허용
                        .maxAge(3600); // 캐시 시간 설정
            }
        };
    }
}
