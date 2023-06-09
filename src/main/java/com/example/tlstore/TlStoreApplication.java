package com.example.tlstore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class TlStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(TlStoreApplication.class, args);
        System.out.println("-----------------------------------------------------------");
        System.out.println("🚀 Server ready at http://localhost:8080");
        System.out.println("🚀 Api doc ready at http://localhost:8080/swagger-ui.html ");
    }

}
