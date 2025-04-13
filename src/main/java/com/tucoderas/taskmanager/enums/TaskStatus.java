package com.tucoderas.taskmanager.enums;

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
