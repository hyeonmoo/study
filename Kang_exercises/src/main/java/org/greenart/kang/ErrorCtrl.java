package org.greenart.kang;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
//@ControllerAdvice // 모든 컨트롤러에서 예외처리
//@ControllerAdvice("org.greenart.kang") // 해당 패키지 내에서의 예외처리
public class ErrorCtrl {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 상태코드를 기본(200)->500으로 변경
	@ExceptionHandler(Exception.class) // 예외 종류 설정 -> 해당 예외 발생시 작동
	public String catcher(Exception ex) { // 예외처리 페이지에서 pageContext.exception 객체 사용 시 모델객체 불필요
		return "error"; // 뷰 페이지 출력
	}
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) // 배열 형태
	public String catcher2(Exception ex, Model m) { //여기서의 모델은 컨트롤러메서드의 모델과는 다른 객체임
		m.addAttribute("ex",ex); // 모델에 예외를 저장
		return "error";
	}
}

