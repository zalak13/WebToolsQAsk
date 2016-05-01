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

import com.neu.qask.dao.AnswerDAO;
import com.neu.qask.dao.QuestionDAO;
import com.neu.qask.dao.TopicDAO;
import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.Answer;
import com.neu.qask.pojo.Question;
import com.neu.qask.pojo.Topic;
import com.neu.qask.pojo.User;


@Controller
public class AnswerController {
	

	@RequestMapping(value ="/postAnswer.htm" , method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("question") Question question,@ModelAttribute("answer") Answer answer, BindingResult result , HttpServletRequest req) throws Exception {
		
	
		try {
			QuestionDAO questionDao = new QuestionDAO();
			AnswerDAO answerDao = new AnswerDAO();
			HttpSession session = req.getSession();
			User usersess = (User)session.getAttribute("sessionUser");
			System.out.println(answer.getMessage());
			System.out.println(req.getParameter("message"));
			System.out.println(req.getParameterValues("questionId"));
			System.out.println(req.getParameter("quid"));
			System.out.println(req.getAttribute("questionId"));
			System.out.println(req.getAttribute("quid"));
			System.out.println(question.getQuestionId());
			System.out.println(question.getMessage());
			System.out.println(question.getTitle());
			System.out.println(answer.getMessage());
			
			System.out.println(usersess.getFirstName());
			//questionDao.get(1);
			Answer answerObj = answerDao.create(questionDao.get(1),answer.getMessage(),usersess);
			//questionDao.update(1,answerObj , usersess);
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