package com.levi;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
public class StudentJDBCTemplate implements StudentDataAccessObject 
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	private final static String CREATE_SQL_ = 
			"insert into student (name, age) values (?, ?)";
	
	private final static String SELECT_SQL_ = 
			"select * from student where id = ?";
	
	private final static String LIST_ALL_SQL_ = 
			"select * from student";
	
	private final static String DELETE_SQL_ = 
			"delete from student where id = ?";
	
	private final static String UPDATE_SQL_ = 
			"update student set age = ? where id = ?";
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age)
	{
		jdbcTemplateObject.update(CREATE_SQL_, name, age);
		System.out.println("Created Student record Name = " + name + " Age = " + age);
	}

	public Student getStudent(Integer id)
	{
		Student student = (Student) jdbcTemplateObject.queryForObject(
				SELECT_SQL_, 
				new Object[] {id}, 
				new StudentMapper());
		return student;
	}

	public List<Student> listStudents()
	{
		List<Student> students = jdbcTemplateObject.query(
				LIST_ALL_SQL_, 
				new StudentMapper());
		return students;
	}

	public void delete(Integer id)
	{
		jdbcTemplateObject.update(DELETE_SQL_, id);
		System.out.println("Deleted Student record with ID = " + id);
	}
	
	public void update(Integer id, Integer age)
	{
		jdbcTemplateObject.update(UPDATE_SQL_, age, id);
		System.out.println("Updated Student record with ID = " + id);
	}
}
