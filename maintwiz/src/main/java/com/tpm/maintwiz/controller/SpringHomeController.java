package com.tpm.maintwiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tpm.maintwiz.service.SpringTest;

@Controller
public class SpringHomeController {
	
	@Autowired
	SpringTest test;
	
	@RequestMapping("/")
	public ModelAndView home() 
	{
		final ModelAndView modelAndView = new ModelAndView();
		System.out.println(test.getString()+" ---->");
		modelAndView.setViewName("/workorder/add_workorder");
		modelAndView.addObject("data", 3);
		return modelAndView;
	}
	
}
