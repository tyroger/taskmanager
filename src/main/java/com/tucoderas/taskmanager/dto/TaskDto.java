package com.tucoderas.taskmanager.dto;

import com.tucoderas.taskmanager.enums.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;
    @NotBlank(message = "Status is required")
    private TaskStatus status = TaskStatus.PENDING;

}
