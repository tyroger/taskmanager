package com.tucoderas.taskmanager.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tucoderas.taskmanager.dto.TaskDto;
import com.tucoderas.taskmanager.entity.TaskEntity;
import com.tucoderas.taskmanager.mapper.TaskMapper;
import com.tucoderas.taskmanager.repository.TaskRepository;
import com.tucoderas.taskmanager.service.interfaces.TaskService;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

/**
 * * TaskServiceImpl is a service class that implements the TaskService
 * interface.
 * It provides methods for creating, retrieving, updating, and deleting tasks.
 */
@Service
public class TaskServiceImpl implements TaskService {

    /**
     * * Logger for logging messages.
     * This logger is used to log messages at different levels (info, debug, error,
     * etc.)
     */
    private static final Logger logger = (Logger) LoggerFactory.getLogger(TaskServiceImpl.class);

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;

    }

    @Override
    public TaskDto createTask(@NotNull TaskDto taskdto) {
        TaskEntity taskEntity = taskMapper.toEntity(taskdto);
        if (taskEntity == null) {
            return null;
        }
        taskEntity = taskRepository.save(taskEntity);
        logger.info("Task created successfully");
        return taskMapper.toDto(taskEntity);
    }

    @Override
    public TaskDto getTaskById(Long taskDtoId) {
        if (taskDtoId == null) {
            return null;
        }
        TaskEntity taskEntity = taskRepository
                .findById(taskDtoId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        logger.info("Task found successfully", taskEntity.getTitle());
        return taskMapper.toDto(taskEntity);
    }

    @Override
    @Transactional
    public void updateTask(Long taskDtoId, TaskDto taskdto) {
        if (taskDtoId == null || taskdto == null) {
            return;
        }
        TaskEntity taskEntity = taskRepository
                .findById(taskDtoId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskEntity.setTitle(taskdto.getName());
        taskEntity.setDescription(taskdto.getDescription());
        taskEntity.setTaskStatus(taskdto.getStatus());
        taskEntity = taskRepository.save(taskEntity);
        taskMapper.toDto(taskEntity);
        logger.info("Task updated successfully");
    }

    @Override
    public void deleteTask(Long taskDtoId) {
        if (taskDtoId == null) {
            return;
        }
        taskRepository.deleteById(taskDtoId);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository
                .findAll()
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

}
