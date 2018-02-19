package com.logicbig.example;

import java.io.Serializable;
import java.util.Objects;

public class CompositeTaskId implements Serializable{
    private int employeeId;
    private int taskId;

    public CompositeTaskId() {
    }

    public CompositeTaskId(int employeeId, int taskId) {
        this.employeeId = employeeId;
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeTaskId taskId1 = (CompositeTaskId) o;
        if (employeeId != taskId1.employeeId) return false;
        return taskId == taskId1.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, taskId);
    }
}