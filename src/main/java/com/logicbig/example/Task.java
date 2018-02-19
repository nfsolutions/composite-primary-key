package com.logicbig.example;


import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import java.util.Date;

@Indexed
@Entity
@IdClass(CompositeTaskId.class)
public class Task {

    @DocumentId
    private String documentId;

    @Id
    private int employeeId;
    @Id
    private int taskId;
    @Field
    private String taskName;
    @Field
    private String taskDescription;
    private Date date;

    public Task() {
    }

    @Transient
    public String getDocumentId() {
        return String.valueOf(employeeId) + String.valueOf(taskId);
    }


    public Task(int employeeId, int taskId) {
        this.employeeId = employeeId;
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "employeeId=" + employeeId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", date=" + date +
                '}';
    }
}