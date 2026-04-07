package com.example.taskmanager.Controllers;

import com.example.taskmanager.Services.PlayerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/players")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public ResponseEntity<List<String>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{ID}")
    public ResponseEntity<String> getPLayer(@PathVariable int ID){
        String result = playerService.getPlayer(ID);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> removePLayer(@PathVariable int ID){
        boolean result = playerService.removePlayer(ID);
        return result ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/{ID}/{name}")
    public ResponseEntity<String> addPlayer (@PathVariable int ID, @PathVariable String name){
        return ResponseEntity.status(201).body(playerService.addPlayer(ID,name));
    }   
}
