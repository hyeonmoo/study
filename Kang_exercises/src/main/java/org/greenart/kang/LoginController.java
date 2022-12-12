package org.greenart.kang;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	@PostMapping("/login")
	public String login(String email, String pw, boolean remId, HttpServletRequest req, HttpServletResponse res, String toURL) throws Exception{
		if(!loginCheck(email,pw)) {
			String msg= URLEncoder.encode("이메일 또는 비밀번호가 일치하지 않습니다.","utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		Cookie cookie = new Cookie("email",email);
		if(!remId) cookie.setMaxAge(0);
		res.addCookie(cookie);
		
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		
		if(toURL==null||toURL.equals("")) toURL="/";
		
		return "redirect:"+toURL;
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	private boolean loginCheck(String email, String pw) {
		return "asdf@a".equals(email)&&"1234".equals(pw);
	}
}
