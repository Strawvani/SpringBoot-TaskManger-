package com.example.taskmanager.Services;

import com.example.taskmanager.Models.Task;
import com.example.taskmanager.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    public Task createTask(String title, String description) {
        Task task = new Task(0, title, description);
        return taskRepository.save(task);
    }

    public boolean deleteTask(int id) {
        return taskRepository.deleteById(id);
    }
}