package com.example.taskmanager;

import java.util.List;

public class PlayerService {

    final PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<String> getAllPlayers(){
        return playerRepository.findAll();
    }

    public String getPlayer(int ID){
        return playerRepository.findByID(ID);
    }
}
