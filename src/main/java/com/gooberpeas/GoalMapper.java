package com.gooberpeas;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GoalMapper implements RowMapper<Goal>
{
	private final static String ID_COLUMN_NAME_ = "id";
	private final static String OWNER_ID_COLUMN_NAME_ = "owner_id";
	private final static String TITLE_COLUMN_NAME_ = "title";
	private final static String DESCRIPTION_COLUMN_NAME_ = "description";
	private final static String STATUS_COLUMN_NAME_ = "status";
	private final static String GOAL_TYPE_COLUMN_NAME_ = "goal_type";
	
	public Goal mapRow(ResultSet rs, int rowNum)
	throws SQLException
	{
		Goal goal = new Goal();
		goal.setId(rs.getInt(ID_COLUMN_NAME_));
		goal.setOwnerId(rs.getInt(OWNER_ID_COLUMN_NAME_));
		goal.setTitle(rs.getString(TITLE_COLUMN_NAME_));
		goal.setDescription(rs.getString(DESCRIPTION_COLUMN_NAME_));
		goal.setStatus(Goal.Status.valueOf(rs.getString(STATUS_COLUMN_NAME_)));
		goal.setGoalType(rs.getString(GOAL_TYPE_COLUMN_NAME_));
		
		return goal;
	}

}
