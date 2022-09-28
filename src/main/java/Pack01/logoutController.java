package Pack01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logoutController {
	@RequestMapping("/tt3")
	
	public String func033() {
		System.out.println("이건 뜨겠지?"); 
		return "logOut";
	}
}


