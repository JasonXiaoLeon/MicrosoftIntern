package com.microsoft.week4.demoProj.Service;

import com.microsoft.week4.demoProj.Entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> getCommentsByNewsId(int newsId);
    void addComment(Comment comment);
    void deleteCommentById(int commentId);
}
