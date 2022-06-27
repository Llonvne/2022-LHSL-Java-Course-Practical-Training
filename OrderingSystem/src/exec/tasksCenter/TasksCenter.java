package exec.tasksCenter;

import exec.Exec;
import exec.recall.Recevier;

public interface TasksCenter extends Exec {
    Recevier<Exec> getTaskRecevier();

    void addTasksEmptyEventListener(Recevier<Boolean> exec);

    void offer(Exec exec);
}
