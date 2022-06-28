package process;

import database.DatabaseInitializer;
import exec.recall.Recevier;
import exec.tasksCenter.StandardTasksCenter;
import exec.tasksCenter.TasksCenter;
import process.welcome.WelcomeTask;

/**
 * 类名:     process.Main
 * 描述:     这是主任务中心
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main {

    // 初始化主任务调度器
    public static final TasksCenter tasksCenter = new StandardTasksCenter();

    public static void main(String[] args) {
        // 当主任务调度器为空时向主任务调度器添加 Welcome 监听器
        Recevier<Boolean> addWelcomeTask = args1 -> tasksCenter.offer(
            // 初始化 WelcomeTask 并绑定 主任务接收器
            new WelcomeTask(tasksCenter.getTaskRecevier())
        );
        // 将监听器绑定到主任务调度器
        tasksCenter.addTasksEmptyEventListener(addWelcomeTask);
        // 想任务中心添加初始化数据库的任务
        tasksCenter.offer(new DatabaseInitializer("OrderingSystem"));
        // 执行任务中心
        tasksCenter.exec();
    }
}