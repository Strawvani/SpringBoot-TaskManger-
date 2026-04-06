package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
		PlayerRepository playerRepository = new PlayerRepository();

		PlayerService playerService = new PlayerService(playerRepository);

		String result = playerService.getPlayer(7);
		System.out.println(result != null ? result : "Player not found");
		System.out.println(playerService.getAllPlayers());
	}

}
