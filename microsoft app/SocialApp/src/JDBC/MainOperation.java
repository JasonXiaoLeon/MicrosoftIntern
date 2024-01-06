package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainOperation {
	private testConnection dbConnection;
	public MainOperation() {
		this.dbConnection = new testConnection();
	}

	public boolean loginUser(String username, String password) {
		try(Connection connection = dbConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM UserInfo WHERE uid = ? AND password_hash = ?")) {
			pstmt.setString(1, username);
	        pstmt.setString(2, password);
			// 处理结果（检查用户是否存在，处理身份验证逻辑）
	        try (ResultSet result = pstmt.executeQuery()) {
                // 处理结果（检查用户是否存在，处理身份验证逻辑）
                return result.next(); // 如果结果集中有下一行，则返回 true，表示用户找到，身份验证成功
            }
			}catch(SQLException e) {
				e.printStackTrace();
	            return false;
			}
    }

    public boolean registerUser(String username, String password, String additionalInfo) {        
    	try (Connection connection = dbConnection.getConnection();
             PreparedStatement checkStmt = connection.prepareStatement("SELECT COUNT(*) FROM UserInfo WHERE uid = ?");
             PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO UserInfo (uid, password_hash, nickname) VALUES (?, ?, ?)")) {

    		// 检查是否已经存在相同的 uid
            checkStmt.setString(1, username);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            int userCount = checkResult.getInt(1);

	        if (userCount > 0) {
	            // 用户已存在，不能重复注册
	            System.out.println("User with the same UID already exists. Registration failed.");
	            return false;
	        }
	        // 执行插入操作
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.setString(3, additionalInfo);

            int rowsAffected = insertStmt.executeUpdate();
			 
			if (rowsAffected > 0) {
	            System.out.println("User registered successfully!");
	            return true;
	        } else {
	            System.out.println("Failed to register user.");
	            return false;
	        }
			
		}catch(SQLException e) {
			e.printStackTrace();
            return false;
		}
    }
    
    public boolean updateUserInfo(String username, String newNickname) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement("UPDATE UserInfo SET nickname = ? WHERE uid = ?")) {
            
            updateStmt.setString(1, newNickname);
            updateStmt.setString(2, username);

            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User information updated successfully!");
                return true;
            } else {
                System.out.println("Failed to update user information.");
                return false;
            }

        } catch (SQLException e) {
            // 记录日志或抛出自定义异常
            e.printStackTrace();
            return false;
        }
    }
    
    public List<News> getNewsList() {
        List<News> newsList = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM NewsContent ORDER BY release_datetime DESC LIMIT 10");
             ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                int newsId = resultSet.getInt("news_id");
                String title = resultSet.getString("title");
                String coverImageUrl = resultSet.getString("cover_image_url");
                String releaseDatetime = resultSet.getString("release_datetime");
                String author = resultSet.getString("author");
                String newsText = resultSet.getString("news_text");
                int viewsCount = resultSet.getInt("views_count");
                int favoritesCount = resultSet.getInt("favorites_count");
                int sharesCount = resultSet.getInt("shares_count");
                boolean paidPromotionFlag = resultSet.getBoolean("paid_promotion_flag");

                News news = new News(newsId, title, coverImageUrl, releaseDatetime, author, newsText,
                        viewsCount, favoritesCount, sharesCount, paidPromotionFlag);
                newsList.add(news);
            }

        } catch (SQLException e) {
            // 打印异常信息或者记录日志
            e.printStackTrace();
            // 或者抛出一个自定义异常，表示获取新闻列表失败
            throw new RuntimeException("Failed to fetch news list", e);
        }

        return newsList;
    }
    //Users browse the news list by title
    public List<News> getNewsListByTitle(String titleKeyword) {
        List<News> newsList = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM NewsContent WHERE title LIKE ? ORDER BY release_datetime DESC LIMIT 10")) {

            pstmt.setString(1, "%" + titleKeyword + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    int newsId = resultSet.getInt("news_id");
                    String title = resultSet.getString("title");
                    String coverImageUrl = resultSet.getString("cover_image_url");
                    String releaseDatetime = resultSet.getString("release_datetime");
                    String author = resultSet.getString("author");
                    String newsText = resultSet.getString("news_text");
                    int viewsCount = resultSet.getInt("views_count");
                    int favoritesCount = resultSet.getInt("favorites_count");
                    int sharesCount = resultSet.getInt("shares_count");
                    boolean paidPromotionFlag = resultSet.getBoolean("paid_promotion_flag");

                    News news = new News(newsId, title, coverImageUrl, releaseDatetime, author, newsText,
                            viewsCount, favoritesCount, sharesCount, paidPromotionFlag);
                    newsList.add(news);
                }
            }

        } catch (SQLException e) {
            // 打印异常信息或者记录日志
            e.printStackTrace();
            // 或者抛出一个自定义异常，表示获取新闻列表失败
            throw new RuntimeException("Failed to fetch news list by title", e);
        }

        return newsList;
    }
    //Users browse the news list by content
    public List<News> searchNewsByContent(String contentKeyword) {
        List<News> newsList = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM NewsContent WHERE news_text LIKE ? ORDER BY release_datetime DESC LIMIT 10")) {

            pstmt.setString(1, "%" + contentKeyword + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    int newsId = resultSet.getInt("news_id");
                    String title = resultSet.getString("title");
                    String coverImageUrl = resultSet.getString("cover_image_url");
                    String releaseDatetime = resultSet.getString("release_datetime");
                    String author = resultSet.getString("author");
                    String newsText = resultSet.getString("news_text");
                    int viewsCount = resultSet.getInt("views_count");
                    int favoritesCount = resultSet.getInt("favorites_count");
                    int sharesCount = resultSet.getInt("shares_count");
                    boolean paidPromotionFlag = resultSet.getBoolean("paid_promotion_flag");

                    News news = new News(newsId, title, coverImageUrl, releaseDatetime, author, newsText,
                            viewsCount, favoritesCount, sharesCount, paidPromotionFlag);
                    newsList.add(news);
                }
            }

        } catch (SQLException e) {
            // 打印异常信息或者记录日志
            e.printStackTrace();
            // 或者抛出一个自定义异常，表示搜索新闻失败
            throw new RuntimeException("Failed to search news by content", e);
        }

        return newsList;
    }
    //Users browse the comment list from news
    public List<Comment> getCommentsForNews(int newsId) {
        List<Comment> commentList = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Comments WHERE news_id = ? ORDER BY comment_time DESC")) {

            pstmt.setInt(1, newsId);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    String userId = resultSet.getString("user_id");
                    int commentId = resultSet.getInt("comment_id");
                    String commentText = resultSet.getString("comment_text");
                    String commentTime = resultSet.getString("comment_time");
                    int referencedCommentId = resultSet.getInt("referenced_comment_id");
                    int likesCount = resultSet.getInt("likes_count");
                    int dislikesCount = resultSet.getInt("dislikes_count");

                    Comment comment = new Comment(userId, commentId, newsId, commentText, commentTime,
                            referencedCommentId, likesCount, dislikesCount);
                    commentList.add(comment);
                }
            }

        } catch (SQLException e) {
            // 打印异常信息或者记录日志
            e.printStackTrace();
            // 或者抛出一个自定义异常，表示获取评论失败
            throw new RuntimeException("Failed to fetch comments for news", e);
        }

        return commentList;
    }


        public boolean addToFavorites(String userId, int newsId) {
            try (Connection connection = dbConnection.getConnection()) {
                // 更新 UserInfo 表的 favorite_list 字段
                String updateUserInfoQuery = "UPDATE UserInfo SET favorite_list = CONCAT(IFNULL(favorite_list, ''), ',', ?) WHERE uid = ?";
                try (PreparedStatement pstmtUserInfo = connection.prepareStatement(updateUserInfoQuery)) {
                    pstmtUserInfo.setInt(1, newsId);
                    pstmtUserInfo.setString(2, userId);
                    pstmtUserInfo.executeUpdate();
                }

                // 更新 NewsContent 表的 favorites_count 字段
                String updateNewsContentQuery = "UPDATE NewsContent SET favorites_count = favorites_count + 1 WHERE news_id = ?";
                try (PreparedStatement pstmtNewsContent = connection.prepareStatement(updateNewsContentQuery)) {
                    pstmtNewsContent.setInt(1, newsId);
                    pstmtNewsContent.executeUpdate();
                }

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean addToShares(String userId, int newsId) {
            try (Connection connection = dbConnection.getConnection()) {
                // 更新 NewsContent 表的 shares_count 字段
                String updateNewsContentQuery = "UPDATE NewsContent SET shares_count = shares_count + 1 WHERE news_id = ?";
                try (PreparedStatement pstmtNewsContent = connection.prepareStatement(updateNewsContentQuery)) {
                    pstmtNewsContent.setInt(1, newsId);
                    pstmtNewsContent.executeUpdate();
                }

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    
    public static void main(String[] args) {
    	MainOperation userRegistration = new MainOperation();
    	System.out.println(userRegistration.loginUser("user@gmail.com","123456"));
    	System.out.println(userRegistration.registerUser("newuser@gmail.com","123456","Lihua"));
    	System.out.println(userRegistration.updateUserInfo("newuser@gmail.com","Liming"));	
    	List<News> newsListByTitle = userRegistration.getNewsListByTitle("AU");
	    for (News news : newsListByTitle) {
	        System.out.println(news.getTitle());
	    }
	    List<News> newsListByContent = userRegistration.searchNewsByContent("news text");
	    for (News news : newsListByContent) {
	        System.out.println(news.getTitle());
	    }
	    
	 // 假设用户点击新闻，newsId 为所点击新闻的ID
	    int newsId = 1; // 替换为实际新闻ID
	    List<Comment> commentsForNews = userRegistration.getCommentsForNews(newsId);

	    // 打印或处理评论列表
	    for (Comment comment : commentsForNews) {
	        System.out.println("Comment by " + comment.getUserId() + ": " + comment.getCommentText());
	        // 还可以处理其他评论信息，比如时间、点赞数等
	    }
	    
	    // 假设用户ID为 "user1"，新闻ID为 1
	    String userId = "user@gmail.com";

	    // 用户收藏新闻
	    System.out.println(userRegistration.addToFavorites(userId, newsId));

	    // 用户分享新闻
	    System.out.println(userRegistration.addToShares(userId, newsId));
    }
}
