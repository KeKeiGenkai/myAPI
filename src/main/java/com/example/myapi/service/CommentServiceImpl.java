package com.example.myapi.service;

import com.example.myapi.CommentRepository;
import com.example.myapi.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myapi.model.*;
import com.example.myapi.model.Comment;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, TaskRepository taskRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Comment createComment(Long taskId, Comment comment) {
        // Добавьте здесь логику для создания комментария, если необходимо
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));

        comment.setTask(task);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        // Добавьте здесь логику для удаления комментария, если необходимо
        commentRepository.deleteById(commentId);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        // Добавьте здесь логику для получения комментария по ID, если необходимо
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id: " + commentId));
    }

    @Override
    public List<Comment> getAllComments() {
        // Добавьте здесь логику для получения всех комментариев, если необходимо
        return commentRepository.findAll();
    }
}
