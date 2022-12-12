package org.greenart.kang;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	@GetMapping("/register/add")
	public String register() {return "registerForm";}
	@PostMapping("/register/add")
	public String save(@Valid User user, BindingResult result) throws Exception{
//		// 유효성 검사
//		if(!isValid(user)) {
////			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
//			return "redirect:/register/add";
//		}
//		System.out.println("result="+result);
		
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result);
		if(result.hasErrors()) return "registerForm";
		return "registerInfo";
	}
//	private boolean isValid(User user) {
//		return true;
//	}
	@InitBinder
	public void toDate(WebDataBinder binder) {
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false)); // 날짜 형식 변환(1)
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println(validatorList);
	}
}
