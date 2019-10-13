package com.levi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp 
{	
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.setMessage("Even old New York was once New Amsterdam.");
		helloSpring.getMessage();
		
		HelloSpring helloFall = (HelloSpring) context.getBean("helloSpring");
	}
}
