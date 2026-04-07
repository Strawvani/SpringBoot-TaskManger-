package com.example.taskmanager.Services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final List<String> tasks = new ArrayList<>();

    public List<String> getAllTasks() {
        return tasks;
    }

    public String getTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return null;
        }
        return tasks.get(index);
    }

    public String addTask(String task) {
        tasks.add(task);
        return task;
    }

    public boolean deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        tasks.remove(index);
        return true;
    }
}

