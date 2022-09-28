package Pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {
	   @RequestMapping("/t1")
	   public String func01(HttpServletRequest request){
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String user_id = request.getParameter("id");
	      String user_pwd = request.getParameter("pwd");
	      System.out.printf("call 5 이름: %s, 나이 : %s\n",user_id,user_pwd);   
	      
	      String driver = "org.mariadb.jdbc.Driver";
	      String url = "jdbc:mysql://127.0.0.1/db01";       // 연결문자열
	      String user = "root";  
	      String pw = "1234";
	      String sql = "select * from vote where id = ? and pwd = ?";

	      
	      try{
	         // 드라이버 호출
	         Class.forName(driver);
	         
	         // conn 생성
	           con = DriverManager.getConnection(url, user, pw);
	         System.out.println("접속성공");
	         
	         // pstmt 생성
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, user_id);
	         pstmt.setString(2, user_pwd);

//	         // sql실행
	         rs = pstmt.executeQuery();
	         System.out.println(pstmt);
	         System.out.println("아이디\t패스워드\t투표결과");
	         System.out.println("---------------------------");
	         if(rs.next()){ // 로그인 성공(인증의 수단 session)
	            user_id = rs.getString("id");
	            user_pwd = rs.getString("pwd");
	            System.out.println("로그인 성공");
	         } else{
	            System.out.println("로그인 실패");
	            return "redirect:index.jsp";
	         }
	      } catch (SQLException e1) {
	         e1.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }finally {
	         System.out.println("조회 완료");
	      }
	      return "loginOk";
	   }

}
