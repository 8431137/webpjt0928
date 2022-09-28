package Pack01;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class voteSystem {
   @RequestMapping("/t2")
   public String func02(Model model, HttpServletRequest request, HttpSession session){
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
      
	      String voteName = request.getParameter("voteName");
	      String userId = (String)session.getAttribute("userId");
	      System.out.println(voteName);
	      System.out.println(userId);
	      String sql1 = "update vote set vote=1 where id='"+userId+"';";
	      String sql2 = "update vote set voteName='"+voteName+"' where id='"+userId+"';";
	      String voteError = "select vote from vote where id = ?";
	      String voteResult = "select voteName from vote;";
	      String overlap = "1";
	      String ho = "호랑이";
	      String doc = "독수리";
	      String ko = "코끼리";
	      int hoCount = 0, docCount = 0, koCount = 0, nullCount =0;
	      
      try {

			
	    	 con = DBConnection.getConnection();
	         System.out.println("접속성공");
	         
			// 투표한 회원 찾기 (에러처리를 위하여)-----------------------------------------------------
			pstmt = con.prepareStatement(voteError);
			pstmt.setString(1, userId);
			System.out.println("db연동 성공");
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(userId+"님의" + "투표한 값 : " +rs.getString("vote"));
				if(overlap.equals(rs.getString("vote"))) {
					System.out.println("이미 투표한 회원입니다.");
				}
			}
			// 투표한 회원 찾기 끝-----------------------------------------------------
				
	         //투표 결과 반영
	         pstmt = con.prepareStatement(sql1);
 	         rs = pstmt.executeQuery();
 	         System.out.println("투표 결과 1로 셋팅 완료");
 	        
	       	 //투표 데이터 입력 	     
 	         pstmt = con.prepareStatement(sql2);
	         rs = pstmt.executeQuery();
 	         System.out.println("투표결과 반영 완료.");

 	         
 			// 투표 결과 views로 넘겨주기 -----------------------------------------------------
 			pstmt = con.prepareStatement(voteResult);
 			System.out.println("투표 결과 views 넘겨주기 성공");
 			rs = pstmt.executeQuery();
 			System.out.println("투표 결과 views 넘겨주기 실행");
 			while(rs.next()){
 				if(ho.equals(rs.getString("voteName")))
 					hoCount++;
 				else if(doc.equals(rs.getString("voteName")))
 					docCount++;
 				else if(ko.equals(rs.getString("voteName")))
 					koCount++;
 				else 
 					nullCount++;
 			}
 	         model.addAttribute("hoCount", hoCount);
 	         model.addAttribute("docCount", docCount);
 	         model.addAttribute("koCount", koCount);
 	         model.addAttribute("nullCount", nullCount);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("조회 완료");
		}
      return "result";
   }
}