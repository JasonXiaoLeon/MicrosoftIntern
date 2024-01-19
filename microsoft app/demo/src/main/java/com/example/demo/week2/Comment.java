package com.example.demo.week2;

public class Comment {
    private String userId;
    private int commentId;
    private int newsId;
    private String commentText;
    private String commentTime;
    private int referencedCommentId;
    private int likesCount;
    private int dislikesCount;

    public Comment() {
        super();
    }

    public Comment(String userId, int commentId, int newsId, String commentText, String commentTime,
                   int referencedCommentId, int likesCount, int dislikesCount) {
        super();
        this.userId = userId;
        this.commentId = commentId;
        this.newsId = newsId;
        this.commentText = commentText;
        this.commentTime = commentTime;
        this.referencedCommentId = referencedCommentId;
        this.likesCount = likesCount;
        this.dislikesCount = dislikesCount;
    }

    // 添加需要的getter方法

    public String getUserId() {
        return userId;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public int getReferencedCommentId() {
        return referencedCommentId;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public int getDislikesCount() {
        return dislikesCount;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userId='" + userId + '\'' +
                ", commentId=" + commentId +
                ", newsId=" + newsId +
                ", commentText='" + commentText + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", referencedCommentId=" + referencedCommentId +
                ", likesCount=" + likesCount +
                ", dislikesCount=" + dislikesCount +
                '}';
    }
}
