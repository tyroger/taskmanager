package com.tucoderas.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.tucoderas.taskmanager.dto.TaskDto;
import com.tucoderas.taskmanager.service.TaskServiceImpl;

import jakarta.validation.Valid;
/**
 * * TaskController is a REST controller that handles HTTP requests related to tasks.
 * It provides endpoints for creating, retrieving, updating, and deleting tasks.
 * The controller uses the TaskServiceImpl to interact with the task service layer.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("")
    public void addTask(@Valid @RequestBody TaskDto taskdto) {
        taskService.createTask(taskdto);
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable Long taskDtoId) {
        return taskService.getTaskById(taskDtoId);
    }

    @PutMapping("")
    public void updateTask(@PathVariable Long taskDtoId, @Valid @RequestBody TaskDto taskdto) {
        taskService.updateTask(taskDtoId,taskdto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long taskDtoId) {
        taskService.deleteTask(taskDtoId);
    }
}
