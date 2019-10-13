package com.levi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp 
{	
	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.setMessage("Even old New York was once New Amsterdam.");
		helloSpring.getMessage();
		
		context.registerShutdownHook();
		System.out.println("registered shutdown hook.");
	}
}
