package exec;

import exec.recall.Recevier;
import exec.recall.Sender;

/**
 * 类名:     TasksWithNotEmptyRecevier
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TasksWithNotEmptyRecevier implements Exec {
    private final Tasks tasks = new Tasks();
    private final Sender<Boolean> sender = new Sender<>();

    public void bindRecevier(Recevier<Boolean> receiver) {
        sender.bindRecevier(receiver);
    }

    public void offer(Exec exec) {
        tasks.offer(exec);
        sender.send(true);
    }

    @Override
    public void exec() {
        tasks.exec();
        sender.send(false);
    }
}
