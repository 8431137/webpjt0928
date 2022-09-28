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
	      String sql1 = "update vote set vote=1 where id='"+userId+"';";
	      String sql2 = "update vote set voteName='"+voteName+"' where id='"+userId+"';";
      try {
	    	 con = DBConnection.getConnection();
	         System.out.println("접속성공");
	         //투표 결과 반영
	         pstmt = con.prepareStatement(sql1);
 	         rs = pstmt.executeQuery();
 	         System.out.println("투표 결과 1로 셋팅 완료");
 	        
//	         투표 데이터 입력 	     
 	         pstmt = con.prepareStatement(sql2);
	         rs = pstmt.executeQuery();
 	         System.out.println("투표결과 반영 완료.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("조회 완료");
		}
      return "result";
   }
   
   @RequestMapping("/t3")
   public String func03(HttpServletRequest request, HttpSession session){
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
   try {
	    	 con = DBConnection.getConnection();
	         System.out.println("접속성공");
	         //투표 결과 반영	       
	         rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("조회 완료");
		}
   return "result";
}

}