package JDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistration {
	private testConnection dbConnection;
	public UserRegistration() {
		this.dbConnection = new testConnection();
	}

	public boolean loginUser(String username, String password) {
		try(Connection connection = dbConnection.getConnection();
			Statement stmt = dbConnection.createStatement()) {
			String query = "SELECT * FROM UserInfo WHERE uid = '" + username + "' AND password_hash = '" + password + "'";
			ResultSet result = stmt.executeQuery(query);
			
			// 处理结果（检查用户是否存在，处理身份验证逻辑）
            if (result.next()) {
                // 用户找到，身份验证成功
                return true;
            } else {
                // 用户未找到或身份验证失败
                return false;
            }
		}catch(SQLException e) {
			e.printStackTrace();
            return false;
		}
    }

    public boolean registerUser(String username, String password, String additionalInfo) {        
    	try(Connection connection = dbConnection.getConnection();
			Statement stmt = dbConnection.createStatement()) {
    		
			
			// 检查是否已经存在相同的 uid
	        String checkQuery = "SELECT COUNT(*) FROM UserInfo WHERE uid = '" + username + "'";
	        ResultSet checkResult = stmt.executeQuery(checkQuery);
	        checkResult.next();
	        int userCount = checkResult.getInt(1);

	        if (userCount > 0) {
	            // 用户已存在，不能重复注册
	            System.out.println("User with the same UID already exists. Registration failed.");
	            return false;
	        }
	        
			String query = "INSERT INTO UserInfo (uid, password_hash, nickname) VALUES ('" + username + "', '" + password + "', '" + additionalInfo + "')";
			 // 执行插入操作
	        int rowsAffected = stmt.executeUpdate(query);
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
