package com.jojoldu.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //CreatedDate, LastModifiedDate null로 들어가는걸 방지하기 위한 어노테이션
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
