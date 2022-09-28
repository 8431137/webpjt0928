package Pack01;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class login {
   @RequestMapping("/t1")
   public String func01(Model model, HttpServletRequest request, HttpSession session){
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String userId = request.getParameter("id");
      String userPwd = request.getParameter("pwd");
      String sql = "select * from vote where id = ? and pwd = ?";
      String voteError = "select vote from vote where id = ?";
      String voteResult = "select voteName from vote;";
      String ho = "호랑이";
      String doc = "독수리";
      String ko = "코끼리";
      String win = "";
      int max=0;
      int hoCount = 0, docCount = 0, koCount = 0, nullCount =0;     
      // overlap은 중복 확인을 위한 코드
      String overlap = "1";
 		try {
 	         // pstmt 생성
 	    	 con = DBConnection.getConnection();
 	         System.out.println("접속성공");
 	         
 	         pstmt = con.prepareStatement(sql);
 	         pstmt.setString(1, userId);
 	         pstmt.setString(2, userPwd);
 	         rs = pstmt.executeQuery();
 	         System.out.println(pstmt);
 	         if(rs.next()){ // 로그인 성공(인증의 수단 session)
 	        	userId = rs.getString("id");
 	        	userPwd = rs.getString("pwd");
 	            System.out.println("로그인 성공");
 	            
 	 			// session 생성 -----------------------------------------------------
 				 session.setAttribute("userId", userId);
 				 session.setMaxInactiveInterval(2700);
 				System.out.println("session 생성 완료"); 
 				
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
 	  				// 당선확률 계산
 	 			}
 	 			
 	 			if(nullCount == 0) {
 	 	             max = hoCount;
 	 	             win = "호랑이";
 	 	              if(docCount > max) {
 	 	                  max = docCount;
 	 	                  win = "독수리";
 	 	              }
 	 	              
 	 	              if(koCount > max) {
 	 	                  max = koCount;
 	 	                 win = "코끼리";
 	 	              }
 	 	          }
 	 			 model.addAttribute("win", win);
	 	         model.addAttribute("hoCount", hoCount);
	 	         model.addAttribute("docCount", docCount);
	 	         model.addAttribute("koCount", koCount);
	 	         model.addAttribute("nullCount", nullCount);
 	 			//Map 연습 용 **************************************************************
// 	 			HashMap<String, Integer> map = new HashMap<>();
// 	 			map.put("호랑이",hoCount);
// 	 			map.put("독수리",docCount);
// 	 			map.put("코끼리",koCount);
// 	 			System.out.println(map.get("value")); 
// 	 			
// 	 			List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
// 	 			entryList.sort(Map.Entry.comparingByValue());
// 	 			
// 	 			for(Map.Entry<String, Integer> entry : entryList){
// 	 			    System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
// 	 			}
 	 				
// 	 			for(Map.Entry<String, Integer> entry : entryList){
// 	 			    System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
// 	 			}
 	 			//Map 연습 끝 ************************************************************** 	

 	 	     
 				// 투표한 회원 찾기 (에러처리를 위하여)-----------------------------------------------------
 				pstmt = con.prepareStatement(voteError);
 				pstmt.setString(1, userId);
 				System.out.println("db연동 성공");
 				rs = pstmt.executeQuery();
 				while(rs.next()){
 					System.out.println(userId+"님의" + "투표한 값 : " +rs.getString("vote"));
 					if(overlap.equals(rs.getString("vote"))) {
 						System.out.println("이미 투표한 회원입니다.");
 						return "result"; //실패 홈페이지로
 						

 	 				}
 				}
 				// 투표한 회원 찾기 끝-----------------------------------------------------
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