package com.example.myapi.service;

import com.example.myapi.CommentRepository;
import com.example.myapi.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myapi.model.*;
import com.example.myapi.model.Comment;
import com.example.myapi.*;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, CommentRepository commentRepository) {
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task task){
        Task existringTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));

        existringTask.setTitle(task.getTitle());
        Task existingTask = new Task();
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setPriority(task.getPriority());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setAuthor(task.getAuthor());

        return taskRepository.save(existingTask);
    }
    @Override
    public void deleteTask(Long taskId) {
        // Добавьте здесь логику для удаления задачи, если необходимо
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task getTaskById(Long taskId) {
        // Добавьте здесь логику для получения задачи по ID, если необходимо
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));
    }

    @Override
    public List<Task> getAllTasks() {
        // Добавьте здесь логику для получения всех задач, если необходимо
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByAuthor(User author) {
        // Добавьте здесь логику для получения задач по автору, если необходимо
        return taskRepository.findByAuthor(author);
    }

    @Override
    public List<Task> getTasksByAssignee(User assignee) {
        // Добавьте здесь логику для получения задач по исполнителю, если необходимо
        return taskRepository.findByAssignee(assignee);
    }

    @Override
    public List<Comment> getCommentsForTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));
        return task.getComments();
    }
}