package org.greenart.kang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error {
	@RequestMapping("/err")
	public String exception_1(Model m) throws Exception{
		throw new Exception("예외가 발생했습니다.");
	}
	@RequestMapping("/nullErr")
	public String exception_2() throws Exception{
		throw new NullPointerException("예외가 발생했습니다.");
	}
}
