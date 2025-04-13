package com.tucoderas.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tucoderas.taskmanager.entity.TaskEntity;

/**
 * Repository interface for Task entity.
 * This interface extends JpaRepository to provide CRUD operations for TaskEntity.
 * The TaskRepository interface is used to interact with the database for task-related operations.
 */
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
