package com.tucoderas.taskmanager.entity;

import com.tucoderas.taskmanager.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity class representing a Task in the database.
 * This class is used to map the Task entity to the database table.
 * It contains fields for the task's ID, title, description, and status.
 * The TaskEntity class is used to create, update, and retrieve tasks from the database.
 */
@Entity
@Data
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String title;
    private String description;
    private TaskStatus taskStatus;
}
