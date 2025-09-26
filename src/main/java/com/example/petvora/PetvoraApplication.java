package com.example.petvora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetvoraApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetvoraApplication.class, args);
        System.out.println("Welcome to spring boot");
    }
}
