package com.neu.qask.controller;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.qask.pojo.Question;
import com.neu.qask.pojo.User;
import org.springframework.validation.ValidationUtils;

public class QuestionValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Question.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Question question = (Question) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.question", "Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "error.invalid.question", "Message Required");
    }
}
