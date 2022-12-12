package org.greenart.kang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Request_Mapping {
	@RequestMapping("/login/hello.do")
	public void exactMapping() {System.out.println("url_pattern=/login/hello.do");}
	@RequestMapping("/login/*")
	public void pathMapping1() {System.out.println("url_pattern=/login/*");}
	@RequestMapping("/login/**/tmp/*.do")
	public void pathMapping2() {System.out.println("url_pattern=/login/**/tmp/*.do");}
	@RequestMapping("/login/??")
	public void pathMapping3() {System.out.println("url_pattern=/login/??");}
	@RequestMapping("*.do")
	public void extensionMapping1() {System.out.println("url_pattern=*.do");}
	@RequestMapping("*.???")
	public void extensionMapping2() {System.out.println("url_pattern=*.???");}
}
