package com.example.myapi.model;

import jakarta.persistence.*;
import com.example.myapi.model.*;
import com.example.myapi.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Comment(String text, Task task, User author) {
        this.text = text;
        this.task = task;
        this.author = author;
    }

    public Comment() {

    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
