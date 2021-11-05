package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.config.AuditorAwareImpl;

@SpringBootApplication
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@ComponentScan(basePackages = { "com.example.*" })
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class BookShopApplication {

	@Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BookShopApplication.class, args);
	}

}
