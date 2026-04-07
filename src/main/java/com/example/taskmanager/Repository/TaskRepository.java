package com.example.taskmanager.Repository;


import com.example.taskmanager.Models.Task;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TaskRepository {

    private final Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Optional<Task> findById(int id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public Task save(Task task) {
        if (task.getId() == 0) {
            task.setId(nextId++);
        }

        tasks.put(task.getId(), task);
        return task;
    }

    public boolean deleteById(int id) {
        return tasks.remove(id) != null;
    }
}