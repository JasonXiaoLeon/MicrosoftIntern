package com.microsoft.week4.demoProj.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "news_id")
    private int newsId;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "comment_time")
    private Date commentTime;

    @Column(name = "referenced_comment_id")
    private int referencedCommentId;

    @Column(name = "likes_count")
    private int likesCount;

    @Column(name = "dislikes_count")
    private int dislikesCount;

    // 省略构造函数和其他方法
}
