package com.myspringlearning.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspringlearning.model.User;
import com.myspringlearning.validators.UserLoginValidator;

//http://javainsimpleway.com/spring-mvc-form-validation-with-custom-validator/

@Controller
public class LoginController {
	@Autowired
	UserLoginValidator userLoginValidator;

	public UserLoginValidator getUserLoginValidator() {
		return userLoginValidator;
	}

	public void setUserLoginValidator(UserLoginValidator userLoginValidator) {
		this.userLoginValidator = userLoginValidator;
	}

	@RequestMapping("/login")
	public ModelAndView login(Model model) {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("login");

		model.addAttribute("frmUser", new User());

		return mv;
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView doAuthenticate(@Valid @ModelAttribute("frmUser") User user, BindingResult result, ModelMap modelMap) {

		ModelAndView mv = new ModelAndView();

		modelMap.addAttribute("frmUser", user);
		
		userLoginValidator.validate(user, result);

		if (result.hasErrors()) {
			mv.setViewName("login");
		} else if (user.getUserName().equals("test") && user.getUserPassword().equals("1234")) {
			mv.setViewName("success");
		} else
			mv.setViewName("login");

		return mv;
	}

}
