package Pack01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	//접속정보를 가지고 있는 클래스
	public static Connection getConnection() {
		Connection conn = null;		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db01";
			conn = DriverManager.getConnection(url, "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return conn; 
	}
}