package com.levi;

public class HelloSpring 
{
	private String message;
	
	public void setMessage(String someMessage)
	{
		message = someMessage;
	}

	public void getMessage()
	{
		System.out.println(new StringBuilder("Your message: ").append(message));
	}
}
