package com.diazero.gestao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import com.diazero.gestao.controller.IncidentController;

@SpringBootApplication(scanBasePackages = { "com.diazero.*" })
@ComponentScan(basePackages = "com.diazero.gestao.servico")
@ComponentScan(basePackageClasses = IncidentController.class)
@EntityScan(basePackages = "com.diazero.gestao.entity")
public class DiazeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiazeroApplication.class, args);
	}

}
