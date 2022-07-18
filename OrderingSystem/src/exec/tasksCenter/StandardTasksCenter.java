package exec.tasksCenter;

import exec.Exec;
import exec.Tasks;
import exec.recall.Recevier;
import exec.recall.Sender;

/**
 * 类名:     AbstractTasksCenter
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class
StandardTasksCenter implements TasksCenter {
    private final Tasks tasks = new Tasks();

    private final Recevier<Exec> receiver = tasks::offer;

    private final Sender<Boolean> tasksEventReceiver = new Sender<>();

    @Override
    public final void exec() {
        tasks.exec();
        tasksEventReceiver.send(true);
        if (tasks.size() > 0) {
            exec();
        }
    }

    @Override
    public final Recevier<Exec> getTaskRecevier() {
        return receiver;
    }

    @Override
    public final void addTasksEmptyEventListener(Recevier<Boolean> eventListener) {
        this.tasksEventReceiver.bindRecevier(eventListener);
    }

    @Override
    public void offer(Exec exec) {
        this.tasks.offer(exec);
    }
}
