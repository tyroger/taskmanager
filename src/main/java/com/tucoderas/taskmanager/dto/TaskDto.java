package com.tucoderas.taskmanager.dto;

import com.tucoderas.taskmanager.enums.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for Task entity.
 * This class is used to transfer data between the client and server.
 * It contains validation annotations to ensure that the data is valid before processing.
 * The TaskDto class is used to create, update, and retrieve tasks.
 */
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
