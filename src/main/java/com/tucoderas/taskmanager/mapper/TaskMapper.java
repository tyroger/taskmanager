package com.tucoderas.taskmanager.mapper;

import com.tucoderas.taskmanager.dto.TaskDto;
import com.tucoderas.taskmanager.entity.TaskEntity;

public class TaskMapper {

    private TaskMapper() {
    }

    // Convert TaskDto to TaskEntity
    public TaskEntity toEntity(TaskDto taskDto) {
        if (taskDto == null) {
            return null;
        }
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskDto.getName());
        taskEntity.setDescription(taskDto.getDescription());
        taskEntity.setTaskStatus(taskDto.getStatus());
        return taskEntity;
    }

    // Convert TaskEntity to TaskDto
    public TaskDto toDto(TaskEntity taskEntity) {
        if (taskEntity == null) {
            return null;
        }
        TaskDto taskDto = new TaskDto();
        taskDto.setName(taskEntity.getTitle());
        taskDto.setDescription(taskEntity.getDescription());
        taskDto.setStatus(taskEntity.getTaskStatus());
        return taskDto;
    }
}
