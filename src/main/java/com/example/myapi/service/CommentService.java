package com.example.myapi.service;

import com.example.myapi.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long taskId, Comment comment);
    void deleteComment(Long commentId);
    Comment getCommentById(Long commentId);
    List<Comment> getAllComments();
}