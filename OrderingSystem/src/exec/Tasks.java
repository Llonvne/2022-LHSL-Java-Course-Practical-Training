package exec;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名:     Tasks
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Tasks implements Exec {
    private final Queue<Exec> tasksQueue = new LinkedList<>();

    @Override
    public final void exec() {
        while (!tasksQueue.isEmpty()) {
            tasksQueue.poll().exec();
        }
    }

    public void offer(Exec exec) {
        tasksQueue.offer(exec);
    }
}
