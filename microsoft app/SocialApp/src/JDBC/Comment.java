package JDBC;

public class Comment {
    private String userId;
    private int commentId;
    private int newsId;
    private String commentText;
    private String commentTime;
    private int referencedCommentId;
    private int likesCount;
    private int dislikesCount;

    public Comment(String userId, int commentId, int newsId, String commentText, String commentTime,
                   int referencedCommentId, int likesCount, int dislikesCount) {
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
}
