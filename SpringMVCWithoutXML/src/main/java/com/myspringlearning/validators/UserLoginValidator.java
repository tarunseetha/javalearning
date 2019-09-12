package com.myspringlearning.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myspringlearning.model.User;

@Component
public class UserLoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		try{
		
			String password = user.getUserPassword();

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "user.username.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "user.password.empty");
			
			if (password.toLowerCase().contains("absa")){
				errors.rejectValue("userPassword", "user.password.notallowedchars");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
