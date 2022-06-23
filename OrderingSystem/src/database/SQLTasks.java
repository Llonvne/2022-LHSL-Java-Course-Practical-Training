package database;

import exec.Exec;
import exec.Tasks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名:     SQLTasks
 * 描述:     该任务队列将专门处理 SQLExec 数据库任务
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public final class SQLTasks implements Exec {

    private final SQLExec before;
    private final SQLExec after;

    public SQLTasks(SQLExec before, SQLExec after) {
        this.before = before;
        this.after = after;
    }

    private final Queue<SQLExec> tasksQueue = new LinkedList<>();

    public void offer(SQLExec sqlExec) {
        tasksQueue.offer(sqlExec);
    }

    @Override
    public void exec() {
        before.exec();
        while (!tasksQueue.isEmpty()) {
            tasksQueue.poll().exec();
        }
        after.exec();
    }
}
