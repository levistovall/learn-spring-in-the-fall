package com.levi;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class StudentMapper implements ParameterizedRowMapper<Student>
{
	private final static String ID_COLUMN_NAME_ = "id";
	private final static String NAME_COLUMN_NAME_ = "name";
	private final static String AGE_COLUMN_NAME_ = "age";
	
	public Student mapRow(ResultSet rs, int rowNum)
	throws SQLException
	{
		Student student = new Student();
		student.setId(rs.getInt(ID_COLUMN_NAME_));
		student.setName(rs.getString(NAME_COLUMN_NAME_));
		student.setAge(rs.getInt(AGE_COLUMN_NAME_));
		
		return student;
	}

}
