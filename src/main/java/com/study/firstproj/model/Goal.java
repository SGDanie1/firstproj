package com.study.firstproj.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Goal {
    int id;
    GoalPriority priority;
    String goalName;
    long deadline;
}
