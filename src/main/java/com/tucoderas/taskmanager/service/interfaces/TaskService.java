package com.tucoderas.taskmanager.service.interfaces;

import java.util.List;
import com.tucoderas.taskmanager.dto.TaskDto;

/**
 * Service interface for managing tasks.
 * Provides methods for adding, retrieving, updating, and deleting tasks.
 */
public interface TaskService {

    /**
     * Adds a new task.
     *
     * @param taskdto the task to add
     * @return the added task
     */
    TaskDto createTask(TaskDto taskdto);

    /**
     * Retrieves a task by its ID.
     *
     * @param id the ID of the task to retrieve
     * @return the retrieved task
     */
    TaskDto getTaskById(Long id);

    /**
     * Updates an existing task.
     *
     * @param id the ID of the task to update
     * @param taskdto the updated task data
     */
    void updateTask(Long id, TaskDto taskdto);

    /**
     * Deletes a task by its ID.
     *
     * @param id the ID of the task to delete
     */
    void deleteTask(Long id);

    /**
     * Retrieves all tasks.
     *
     * @return a list of all tasks
     */
    List<TaskDto> getAllTasks();

}
