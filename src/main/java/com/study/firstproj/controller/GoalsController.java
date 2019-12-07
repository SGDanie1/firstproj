package com.study.firstproj.controller;

import com.study.firstproj.model.Goal;
import com.study.firstproj.service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goals")
public class GoalsController {

    private final GoalService goalService;

    public GoalsController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> saveGoal(@RequestBody Goal goal) {
        goalService.saveGoal(goal);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("savedGoal", goal.getGoalName());
        return ResponseEntity.ok(responseMap);
    }

    @GetMapping
    public ResponseEntity<List<Goal>> getAllGoals () {
        return ResponseEntity.ok(
                goalService.getAllGoals()
        );
    }
}
