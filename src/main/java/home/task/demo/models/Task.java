package home.task.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

public class Task {
    @Id
    private Long id;
    private String name;
    private Date completed;
    private String description;
    private long totalSeconds;
    private boolean active;

    public Task(long id, String name, Date completed, String description, long totalSeconds, boolean active) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.description = description;
        this.totalSeconds = totalSeconds;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCompleted() {
        return completed;
    }

    public String getDescription() {
        return description;
    }

    public long getTotalSeconds() {
        return totalSeconds;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTotalSeconds(long totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
