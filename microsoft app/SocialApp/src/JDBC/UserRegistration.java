package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public static void main(String[] args) {
    	UserRegistration userRegistration = new UserRegistration();
    	System.out.println(userRegistration.loginUser("user@gmail.com","123456"));
    	System.out.println(userRegistration.registerUser("newuser@gmail.com","123456","Lihua"));

    }
}

