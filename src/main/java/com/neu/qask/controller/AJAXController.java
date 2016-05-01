package com.neu.qask.controller;

   
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.qask.dao.QuestionDAO;
import com.neu.qask.dao.TopicDAO;
import com.neu.qask.dao.UserDAO;
import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.Question;
import com.neu.qask.pojo.Topic;
import com.neu.qask.pojo.User;


@Controller
public class AJAXController {

	@RequestMapping(value ="/checkEmailAddress.htm" , method = RequestMethod.GET)
	protected User checkEmailAddres(@ModelAttribute("user") User user ,HttpServletRequest req ,HttpServletResponse resp) throws Exception {
		Boolean Result = false;
		try {
			UserDAO userDao = new UserDAO();
			String emailId = (String)req.getParameter("email");
			Result = userDao.checkEmail(emailId);
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		PrintWriter out;
            if (Result) {
                out = resp.getWriter();
                out.println("Email Address has already been registered.");

            }

		return null;
	}
	
	@RequestMapping(value ="/getTopicsList.htm" , method = RequestMethod.GET)
	protected String getTopicsList(@ModelAttribute("user") User user ,HttpServletRequest req ,HttpServletResponse resp) throws Exception {
		List<Topic> Result = new ArrayList<Topic>();
		JSONObject jsonResult = new JSONObject();
		try {
			JSONArray array = new JSONArray();
			TopicDAO topicDao = new TopicDAO();
			Result = topicDao.getTopiclist();
			 for (Topic topic: Result) {
	                JSONObject item = new JSONObject();
	                item.put("topicId", topic.getId());
	                item.put("topicName", topic.getTopicname());
	                array.put(item);
	            }
			 jsonResult.put("results", array);
			 String message = jsonResult.toString();
				PrintWriter out;
	            if (message!="") {
	                out = resp.getWriter();
	                out.write(message);
	            }
			 	
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		} catch(JSONException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	@RequestMapping(value ="/getTopQuestionsList.htm" , method = RequestMethod.GET)
	protected String getTopQuestionsList(@ModelAttribute("user") User user ,HttpServletRequest req ,HttpServletResponse resp) throws Exception {
		List<Question> questionBank = new ArrayList<Question>();
		JSONObject jsonResult = new JSONObject();
		try {
			QuestionDAO questionDao = new QuestionDAO();
			questionBank = questionDao.getQuestionlist();
			JSONArray array = new JSONArray();
			System.out.println(questionBank.size());
			 for (Question question: questionBank) {
				 
	                JSONObject item = new JSONObject();
	               /* for (Topic topic: question.getTopics()) {
	                	JSONObject topicitems = new JSONObject();
	                	topicitems.put("questionTopics",topic);
	                }*/
	                
	                System.out.println(question.getAnswerDetails());
	                System.out.println(question.getAnswerDetails().size());
	                
	                item.put("questionTopics", question.getTopics());
	                item.put("questionId", question.getQuestionId());
	                item.put("questionTitle", question.getTitle());
	                item.put("questionDesc", question.getMessage());
	                item.put("postedBy", question.getPostedBy());
	               // item.put("Answerdetails", question.getAnswerDetails());
	                array.put(item);
	            }
			 jsonResult.put("results", array);
			 String message = jsonResult.toString();
			 System.out.println(message);
				PrintWriter out;
	            if (message!="") {
	                out = resp.getWriter();
	                out.write(message);
	            }
			 	
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		} catch(JSONException e){
			e.printStackTrace();
		}
		
		return null;
	}

}