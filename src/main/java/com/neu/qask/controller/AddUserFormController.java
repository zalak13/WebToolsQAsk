package com.neu.qask.controller;

   
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.qask.dao.UserDAO;
import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.User;


@Controller
public class AddUserFormController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value ="/adduser.htm" , method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest req) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "index";
		}
		HttpSession session = req.getSession();
		try {
			UserDAO userDao = new UserDAO();
			User userCreated = userDao.create(user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName());
			if(userCreated!=null){
				session.setAttribute("sessionUser", userCreated);
            }
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "homepage";
	}

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "index";
	}
}