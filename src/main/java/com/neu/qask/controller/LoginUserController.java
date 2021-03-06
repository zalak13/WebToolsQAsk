package com.neu.qask.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,Model model, HttpServletRequest req) throws Exception {
		//Boolean userFound=false;
		HttpSession session = req.getSession();
		try {
			UserDAO userDao = new UserDAO();
			User userFound = userDao.checkUser(user.getEmail(), user.getPassword());
			System.out.print(userFound);
			if(userFound!=null){
				session.setAttribute("sessionUser", userFound);
            	return "homepage";
            }
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		model.addAttribute("ErrorMsg", "Invalid Credentials");
		return "index";
	}
	
    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
/*        HttpSession session = request.getSession();
        session.invalidate();*/
        return "index";
    }
	
}