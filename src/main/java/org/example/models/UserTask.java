package org.example.models;

import java.util.Date;
import java.util.Objects;

public class UserTask {

    private String taskName;

    private Date taskDate;

    private String description;

    private boolean complete;

    private User user;

    public UserTask(){}

    public UserTask(String taskName, Date taskDate, String description, boolean complete) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.description = description;
        this.complete = complete;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserTask userTask = (UserTask) o;
        return complete == userTask.complete && Objects.equals(taskName, userTask.taskName) && Objects.equals(taskDate, userTask.taskDate) && Objects.equals(description, userTask.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, taskDate, description, complete);
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskName='" + taskName + '\'' +
                ", taskDate=" + taskDate +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                '}';
    }
}
