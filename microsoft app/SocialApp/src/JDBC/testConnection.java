package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/SocialApps";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    
    public static void main(String[] args) {
        Connection connection = null;
	    // 尝试建立数据库连接
	    try {
	        // 注册MySQL JDBC驱动程序
	        Class.forName("com.mysql.cj.jdbc.Driver");
	
	        // 建立连接
	        connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	
	        // 如果连接成功，打印成功消息
		        if (connection != null) {
		            System.out.println("成功连接到MySQL数据库！");
		            // 在此处执行数据库操作
		        }
		    } catch (ClassNotFoundException e) {
		        System.err.println("无法找到MySQL JDBC驱动程序");
		        e.printStackTrace();
		    } catch (SQLException e) {
		        System.err.println("数据库连接失败");
		        e.printStackTrace();
		    }finally {
	            // 在 finally 块中关闭连接
	            if (connection != null) {
	                try {
	                    connection.close();
	                    System.out.println("数据库连接已关闭！");
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
		    }
	}
	    // 获取数据库连接的方法
	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	    }
	    public Statement createStatement() throws SQLException {
	        Connection connection = getConnection();
	        return connection.createStatement();
	    }
}
