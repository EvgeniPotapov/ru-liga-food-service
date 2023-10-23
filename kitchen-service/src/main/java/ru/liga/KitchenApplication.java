package ru.liga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class KitchenApplication {

    public static void main(String[] args) {

        SpringApplication.run(KitchenApplication.class,args);
    }
}
