package com.microsoft.week4.demoProj.Service;

import com.microsoft.week4.demoProj.Entity.Comment;
import com.microsoft.week4.demoProj.Mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentsByNewsId(int newsId) {
        // 根据新闻ID获取评论列表
        // 示例代码，实际业务逻辑根据需求自行实现
        return commentMapper.selectList(null);
    }

    @Override
    public void addComment(Comment comment) {
        // 发表评论
        commentMapper.insert(comment);
    }

    @Override
    public void deleteCommentById(int commentId) {
        // 根据评论ID删除评论
        commentMapper.deleteById(commentId);
    }
}
