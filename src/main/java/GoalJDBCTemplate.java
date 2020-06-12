import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.google.gson.Gson;

public class GoalJDBCTemplate implements GoalDataAccessObject 
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	private final static String CREATE_SQL_ = 
			"insert into goals (title, description, goal_type) values (?, ?, ?)";
	
	private final static String SELECT_SQL_ = 
			"select * from goals where id = ?";
	
	private final static String LIST_ALL_SQL_ = 
			"select * from goals";
	
	private final static String DELETE_SQL_ = 
			"delete from goals where id = ?";
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public String listStudentsAsJsonString()
	{
		Gson gsonObj = new Gson();
		return gsonObj.toJson(listGoals());
	}

	public void delete(Integer id)
	{
		jdbcTemplateObject.update(DELETE_SQL_, new Object[]{id});
		System.out.println("Deleted Student record with ID = " + id);
	}
	
	@Override
	public void create(String title, String description, String goalType) {
		jdbcTemplateObject.update(CREATE_SQL_, new Object[] {title, description, goalType});
	}

	@Override
	public Goal getGoal(Integer id) {
		Goal goal = (Goal) jdbcTemplateObject.queryForObject(
				SELECT_SQL_, 
				new Object[] {id}, 
				new GoalMapper());
		return goal;
	}

	@Override
	public List<Goal> listGoals() {
		List<Goal> goals = jdbcTemplateObject.query(
				LIST_ALL_SQL_, 
				new GoalMapper());
		return goals;
	}
}
