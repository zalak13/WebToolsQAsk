package com.neu.qask.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/home.htm")
public class HomePageController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("firstPageMessage", "This is the first page");
        return "homepage";
    }
}

//public class HomePageController {
//	@Autowired
//	@Qualifier("userValidator")
//	UserValidator validator;
//
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
//
//	@RequestMapping(value ="/adduser.htm" , method = RequestMethod.POST)
//	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "index";
//		}
//
//		try {
//			System.out.print("test");
//			UserDAO userDao = new UserDAO();
//			System.out.print("test1");
//			
//			userDao.create(user.getUserName(), user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName());
//			
//			// DAO.close();
//		} catch (AdException e) {
//			System.out.println("Exception: " + e.getMessage());
//		}
//
//		return "addedUser";
//	}
//
//	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
//	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {
//
//		return "index";
//	}
//}