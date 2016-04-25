package com.neu.qask.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.qask.dao.QuestionDAO;
import com.neu.qask.dao.TopicDAO;
import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.Question;
import com.neu.qask.pojo.Topic;
import com.neu.qask.pojo.User;


@Controller
public class QuestionController {
	
	
	@Qualifier("questionValidator")
	QuestionValidator validator;

/*	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
*/
	@RequestMapping(value ="/postQuestion.htm" , method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("question") Question question, BindingResult result , HttpServletRequest req) throws Exception {
		
/*		validator.validate(question, result);
		if (result.hasErrors()) {
			return "hompage";
		}*/
	
		try {
			QuestionDAO questionDao = new QuestionDAO();
			TopicDAO topicDao = new TopicDAO();
			List<Topic> topicList = new ArrayList<Topic>(); 
			String[] topicArray = req.getParameterValues("topics");
			System.out.println(topicArray);
			for (int i = 0; i < topicArray.length; i++) {
				Topic topic = topicDao.get(topicArray[i]);
				topicList.add(topic);
			}
			HttpSession session = req.getSession();
			User usersess = (User)session.getAttribute("sessionUser");
			System.out.println(usersess.getUserName());
			questionDao.create(question.getTitle(), question.getMessage(), usersess,topicList);
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "homepage";
	}
	
	/*@RequestMapping(value ="/loginuser.htm", method = RequestMethod.POST)
	public String initializeForm(@ModelAttribute("question") Question question, BindingResult result) {
		System.out.println("Here I ama lo nolo ");
		return "loginuser";
	}*/
	
}