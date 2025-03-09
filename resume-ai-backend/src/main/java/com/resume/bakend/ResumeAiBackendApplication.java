package com.resume.bakend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.resume.bakend"})
public class ResumeAiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeAiBackendApplication.class, args);
	}

}
