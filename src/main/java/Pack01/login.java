package Pack01;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class login {
   @RequestMapping("/t1")
   public String func01(HttpServletRequest request, HttpSession session){
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String userId = request.getParameter("id");
      String userPwd = request.getParameter("pwd");
      String sql = "select * from vote where id = ? and pwd = ?";
     
 		try {
 	         // pstmt 생성
 	    	 con = DBConnection.getConnection();
 	         System.out.println("접속성공");
 	         pstmt = con.prepareStatement(sql);
 	         pstmt.setString(1, userId);
 	         pstmt.setString(2, userPwd);
 	         rs = pstmt.executeQuery();
 	         System.out.println(pstmt);
 	         System.out.println("아이디\t패스워드\t투표결과");
 	         System.out.println("---------------------------");
 	         if(rs.next()){ // 로그인 성공(인증의 수단 session)
 	        	userId = rs.getString("id");
 	        	userPwd = rs.getString("pwd");
 	            System.out.println("로그인 성공");
 	 			// session 생성
 				 session.setAttribute("userId", userId);
 				 session.setMaxInactiveInterval(2700);
 	         } else{ // 로그인 실패
 	            System.out.println("로그인 실패");
 	            return "redirect:index.jsp";
 	         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("조회 완료");
		}
      return "loginOk";
   }
}