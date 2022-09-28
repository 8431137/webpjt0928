package Pack01;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class voteSystem {
   @RequestMapping("/t2")
   public String func02(HttpServletRequest request, HttpSession session){
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
      
	      String voteName = request.getParameter("voteName");
	      String userId = (String)session.getAttribute("userId");
	      System.out.println(voteName);
	      System.out.println(userId);
	//      String sql = "UPDATE vote SET vote='1' WHERE id="+userId+";";
	      String sql = "update vote set vote=1 where id='"+userId+"';";
      try {
	    	 con = DBConnection.getConnection();
	         System.out.println("접속성공");
	         pstmt = con.prepareStatement(sql);
 	         rs = pstmt.executeQuery();
 	        System.out.println("쿼리문 실행 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("조회 완료");
		}
      return "result";
   }
}