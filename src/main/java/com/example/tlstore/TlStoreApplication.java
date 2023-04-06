package com.example.tlstore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TlStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(TlStoreApplication.class, args);
        System.out.println("-----------------------------------------------------------");
        System.out.println("🚀 Server ready at http://localhost:8081");
        System.out.println("🚀 Api doc ready at http://localhost:8081/swagger-ui.html ");
    }

}
