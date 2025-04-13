package com.tucoderas.taskmanager.entity;

import com.tucoderas.taskmanager.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
