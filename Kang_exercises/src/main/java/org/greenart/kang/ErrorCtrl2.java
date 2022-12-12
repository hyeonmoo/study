package org.greenart.kang;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //400번 오류
class MyException extends RuntimeException{
	 MyException(String msg){
		 super(msg);
	 }
	 MyException(){}
}
@Controller
public class ErrorCtrl2 {
	@RequestMapping("/err2")
	public String main() throws Exception{
		throw new MyException("예외 발생");
	}
}
