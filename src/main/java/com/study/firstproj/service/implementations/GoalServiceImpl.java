package com.study.firstproj.service.implementations;

import com.study.firstproj.model.Goal;
import com.study.firstproj.model.GoalPriority;
import com.study.firstproj.service.GoalService;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoalServiceImpl implements GoalService {
    private final DataSource dataSource;

    public GoalServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void saveGoal(Goal goal) {
        System.out.println("SAVING!!!");
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO goals(id, priority, goal_name, deadline) VALUES ('" +
                    goal.getId() + "', '" +
                    goal.getPriority() + "', '" +
                    goal.getGoalName() + "', " +
                    goal.getDeadline() + ')'
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Goal> getAllGoals() {
        List<Goal> myGoals = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("select * from goals")) {
                while (resultSet.next()) {
                    myGoals.add(new Goal(
                            resultSet.getInt("id"),
                            GoalPriority.valueOf(resultSet.getNString("priority")),
                            resultSet.getString("goal_name"),
                            resultSet.getLong("deadline")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myGoals;
    }
}
