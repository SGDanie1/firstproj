CREATE TABLE IF NOT EXISTS goals
(
    id        int,
    priority  text,
    goal_name text,
    deadline  long,
    PRIMARY KEY (id)
);
