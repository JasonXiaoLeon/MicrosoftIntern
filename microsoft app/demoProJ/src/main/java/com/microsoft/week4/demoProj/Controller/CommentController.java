package com.microsoft.week4.demoProj.Controller;
import com.microsoft.week4.demoProj.Entity.Comment;
import com.microsoft.week4.demoProj.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/news/{newsId}")
    public List<Comment> getCommentsByNewsId(@PathVariable int newsId) {
        return commentService.getCommentsByNewsId(newsId);
    }

    @PostMapping("/add")
    public void addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteCommentById(@PathVariable int commentId) {
        commentService.deleteCommentById(commentId);
    }
}
