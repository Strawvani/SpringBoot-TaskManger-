package com.example.taskmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);

	}

	@Bean
	public CommandLineRunner run(PlayerService playerService) {
		return args -> {
			String result = playerService.getPlayer(1);
			System.out.println(playerService.getAllPlayers());
			System.out.println(result != null ? result : "Player not Found.");
			result = playerService.getPlayer(7);
			System.out.println(result != null ? result : "Player not Found.");
		};
	}
}
