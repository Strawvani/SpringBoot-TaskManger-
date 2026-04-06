package com.example.taskmanager.Services;

import com.example.taskmanager.Repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<String> getAllPlayers(){
        return playerRepository.findAll();
    }

    public String getPlayer(int ID){
        return playerRepository.findByID(ID);
    }

    public boolean removePlayer(int ID){
        return playerRepository.deleteByID(ID);
    }
}
