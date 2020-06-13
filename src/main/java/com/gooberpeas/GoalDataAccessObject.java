package com.gooberpeas;
import java.util.List;
import javax.sql.DataSource;

public interface GoalDataAccessObject 
{
	public void setDataSource(DataSource ds);

	public void create(
			String title, 
			String description,
			String goal_type);
	
	public Goal getGoal(Integer id);
	
	public List<Goal> listGoals();
	
	public void delete(Integer id);
	
}
