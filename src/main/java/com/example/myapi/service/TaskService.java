package com.example.myapi.service;

import com.example.myapi.model.Comment;
import com.example.myapi.model.*;
import com.example.myapi.*;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Long taskId, Task task);
    void deleteTask(Long taskId);
    Task getTaskById(Long taskId);
    List<Task> getAllTasks();
    List<Task> getTasksByAuthor(User author);
    List<Task> getTasksByAssignee(User assignee);
    List<Comment> getCommentsForTask(Long taskId);
}