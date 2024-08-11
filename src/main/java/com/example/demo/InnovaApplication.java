package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Innova", version = "1.0.0", description = "Conexion"))
public class InnovaApplication {
    public static void main(String[] args) {
        SpringApplication.run(InnovaApplication.class, args);
    }
}
