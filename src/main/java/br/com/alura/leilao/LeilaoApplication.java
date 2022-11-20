package br.com.alura.leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeilaoApplication {

	// Intellij ativar VM options a adicionar as linhas abaixo.
	//-Dspring.profiles.active=test
	//-Dbrowser=firefox
	// como Environment variable => SPRING_PROFILES_ACTIVE=test
	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}
	
}
