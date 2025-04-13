package com.tucoderas.taskmanager.enums;

/**
 * Enum representing the status of a task.
 * This enum is used to define the different states a task can be in.
 * The TaskStatus enum is used to track the progress of tasks in the system.
 */
public enum TaskStatus {
    PENDING("pending"),
    IN_PROGRESS("in_progress"),
    ON_HOLD("on_hold"), 
    FAILED("failed"),
    COMPLETED("completed"),
    CANCELLED("cancelled"),
    DELETED("deleted");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
