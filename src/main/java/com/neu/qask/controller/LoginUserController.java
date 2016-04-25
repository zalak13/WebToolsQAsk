package com.neu.qask.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neu.qask.dao.UserDAO;
import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.User;


@Controller

public class LoginUserController {
	

	@RequestMapping(value ="/loginuser.htm" , method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,Model model) throws Exception {
		Boolean userFound=false;
		try {
			UserDAO userDao = new UserDAO();
			userFound = userDao.checkUser(user.getEmail(), user.getPassword());
			System.out.print(userFound);
			if(userFound){
			return "homepage";
			}
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		model.addAttribute("ErrorMsg", "Invalid Credentials");
		return "index";
	}

}