package com.levi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller

public class LeviController 
{
	@Autowired
	StudentJDBCTemplate template;
	
	@RequestMapping(value="/levi", method = RequestMethod.GET)
	public String printHello(ModelMap model) 
	{
		model.addAttribute("message", "I don't know what I'm doing!");
		return "levi";
	}

	@RequestMapping(value="/viewstudents", method=RequestMethod.GET)
	public String viewAllStudents(ModelMap model)
	{
		List<Student> list = template.listStudents();
		model.addAttribute("list", list);
		return "viewall";
	}

	@RequestMapping(value="/getstudents", method=RequestMethod.GET)
	public String getAllStudents(ModelMap model)
	{
		return template.listStudentsAsJsonString();
	}
}