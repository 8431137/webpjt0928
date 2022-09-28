package Pack01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logout {
   @RequestMapping("/t3")
   public String func03(HttpServletRequest request, HttpSession session){
	   session.invalidate();
        return "redirect:index.jsp";
   }
}