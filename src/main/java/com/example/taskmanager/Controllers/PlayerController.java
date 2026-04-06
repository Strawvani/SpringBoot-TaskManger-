package com.example.taskmanager.Controllers;

import com.example.taskmanager.Services.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/api/players")
    public List<String> getAllStudents(){
        return playerService.getAllPlayers();
    }


}
