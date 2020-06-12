package main.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

@Controller

public class LeviController 
{
	@Autowired
	GoalJDBCTemplate template;
	
	@RequestMapping(value="/levi", method = RequestMethod.GET)
	public String printHello(ModelMap model) 
	{
		model.addAttribute("message", "I don't know what I'm doing!");
		return "levi";
	}

	@RequestMapping(value="/creategoal", method=RequestMethod.POST)
	public String createGoal(@RequestBody Goal goal)
			/*@RequestParam(name = "title") String title,
			@RequestParam(name = "description") String description,
			@RequestParam(name = "goalType") String goalType
			)*/
	{
		template.create(goal.getTitle(), goal.getDescription(), goal.getGoalType());
		return "created goal";
	}

	/*@RequestMapping(value="/getstudents", method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String getAllStudents(ModelMap model)
	{
		return template.listStudentsAsJsonString();
	}*/
}