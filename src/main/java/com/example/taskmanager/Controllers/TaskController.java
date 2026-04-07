package com.example.taskmanager.Controllers;

import com.example.taskmanager.Services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<String> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{index}")
    public ResponseEntity<String> getTask(@PathVariable int index) {
        String task = taskService.getTask(index);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody String task) {
        String created = taskService.addTask(task);
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