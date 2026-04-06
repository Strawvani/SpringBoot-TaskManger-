package com.example.taskmanager.Repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PlayerRepository {
    private HashMap<Integer,String>players = new HashMap<>();

    public PlayerRepository(){
        players.put(1,"Jordan");
        players.put(2,"Arkin");
        players.put(3,"Ryan");
        players.put(4,"Chichi");
        players.put(5,"Bruno");
        players.put(6,"Coco");
    }

    public List<String> findAll(){
        return new ArrayList<>(players.values());
    }

    public String findByID(int ID){
        return players.get(ID);
    }

    public boolean deleteByID(int ID){
        return players.remove(ID) != null;
    }
}
