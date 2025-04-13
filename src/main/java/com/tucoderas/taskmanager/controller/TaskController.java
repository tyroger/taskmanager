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

    @GetMapping("/{taskDtoId}")
    public TaskDto getTaskById(@PathVariable("taskDtoId") Long taskDtoId) {
        return taskService.getTaskById(taskDtoId);
    }

    @PutMapping("/{taskDtoId}")
    public void updateTask(@PathVariable("taskDtoId") Long taskDtoId, @Valid @RequestBody TaskDto taskdto) {
        taskService.updateTask(taskDtoId,taskdto);
    }

    @DeleteMapping("/{taskDtoId}")
    public void deleteTask(@PathVariable("taskDtoId") Long taskDtoId) {
        taskService.deleteTask(taskDtoId);
    }
}
