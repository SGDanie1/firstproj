package com.study.firstproj.service;

import com.study.firstproj.model.Goal;

import java.util.List;

public interface GoalService {

    void saveGoal(Goal goal);

    List<Goal> getAllGoals();
}
