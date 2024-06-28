package com.eduquei.Eduquei;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Eduquei", version = "1", description = "API desenvolvida para plataforma de aulas EAD"))
public class EduqueiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduqueiApplication.class, args);
	}

}
