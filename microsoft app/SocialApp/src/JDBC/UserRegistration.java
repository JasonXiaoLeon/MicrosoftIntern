package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRegistration {
	private testConnection dbConnection;
	public UserRegistration() {
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

    
    public static void main(String[] args) {
    	UserRegistration userRegistration = new UserRegistration();
    	System.out.println(userRegistration.loginUser("user@gmail.com","123456"));
    	System.out.println(userRegistration.registerUser("newuser@gmail.com","123456","Lihua"));

    }
}
