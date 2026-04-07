package com.example.taskmanager.Controllers;

import com.example.taskmanager.Models.Task;
import com.example.taskmanager.Services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Task> getTask(@PathVariable int index) {
        Optional<Task> task = taskService.getTaskById(index);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task.get());
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task created = taskService.createTask(task.getTitle(), task.getDescription());
        return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deleteTask(@PathVariable int index) {
        boolean deleted = taskService.deleteTask(index);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}