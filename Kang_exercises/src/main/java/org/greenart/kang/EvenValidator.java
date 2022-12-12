package org.greenart.kang;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EvenValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Even.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Even even = (Even)target;
		int num_X = even.getNum_X();
		int num_Y = even.getNum_Y();
		
		if(num_X%2==1) errors.rejectValue("num_X", "notEvenNumber", new String[] {"X"},null);
		if(num_Y%2==1) errors.rejectValue("num_Y", "notEvenNumber", new String[] {"Y"},null);
		
		if(num_X!=0 && num_X%2==0) errors.rejectValue("num_X", "EvenNumber", new String[] {"X"},null);
		if(num_Y!=0 && num_Y%2==0) errors.rejectValue("num_Y", "EvenNumber", new String[] {"Y"},null);
	}

}
