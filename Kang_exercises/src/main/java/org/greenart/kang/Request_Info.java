package org.greenart.kang;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Request_Info {
	@RequestMapping("/req_info")
	public void main(HttpServletRequest req) {
		System.out.println("요청 내용의 인코딩: "+req.getCharacterEncoding());
		System.out.println("요청 내용의 길이(알수없음:-1): "+req.getContentLength());
		System.out.println("요청 내용의 타입(알수없음:null): "+req.getContentType());
		
		System.out.println("요청 방법: "+req.getMethod());
		System.out.println("프로토콜,버전: "+req.getProtocol());
		System.out.println("프로토콜: "+req.getScheme());
		
		System.out.println("서버이름|ip주소: "+req.getServerName());
		System.out.println("서버 포트: "+req.getServerPort());
		System.out.println("요청 URL: "+req.getRequestURL());
		System.out.println("요청 URI: "+req.getRequestURI());
		
		System.out.println("Context 경로: "+req.getContextPath());
		System.out.println("Servlet 경로: "+req.getServletPath());
		System.out.println("쿼리스트링: "+req.getQueryString());
		
		System.out.println("로컬 이름: "+req.getLocalName());
		System.out.println("로컬 포트: "+req.getLocalPort());
		
		System.out.println("원격 ip주소: "+req.getRemoteAddr());
		System.out.println("원격 호스트: "+req.getRemoteHost());
		System.out.println("원격 포트: "+req.getRemotePort());
	}
}
