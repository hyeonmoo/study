package org.greenart.kang;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EvenNumberCtrl {
	@GetMapping("/even")
	public String even_get() {
		return "evenNum";
	}
	@PostMapping("/even")
	public String even_post(@Valid Even even, BindingResult bres) throws Exception{
		System.out.println(bres);
		return "evenNum";
	}
	
	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.setValidator(new EvenValidator());
		List<Validator> valList = binder.getValidators();
		System.out.println(valList);
	}
}
