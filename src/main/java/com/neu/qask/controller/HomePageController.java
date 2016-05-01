package com.neu.qask.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping()
public class HomePageController {
 
    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("firstPageMessage", "This is the first page");
        return "homepage";
    }
    

}

