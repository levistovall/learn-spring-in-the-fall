package com.levi;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.levi.StudentJDBCTemplate;

public class MainApp 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		StudentJDBCTemplate template = 
				(StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("---------------- Records Creation ----------------");
		template.create("Zara", 11);
		template.create("Fergus", 71);
		template.create("Elijah", 23);
		
		System.out.println("------------ Listing Multiple Records ------------");
		List<Student> students = template.listStudents();
		
		for(Student student : students)
		{
			System.out.print("ID : " + student.getId());
			System.out.print(", Name : " + student.getName());
			System.out.println(", Age : " + student.getAge());
		}
		
		System.out.println("--------- Updating Student Record With ID = 2 --------");
		template.update(2, 72);
		System.out.println("--------- Displaying newly updated record --------");
		Student student = template.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());
	}

}
