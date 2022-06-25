package process;

import exec.Exec;
import exec.TasksWithNotEmptyRecevier;
import exec.recall.Recevier;
import process.forms.LoginUI;
import process.login.LoginTask;

/**
 * 类名:     process.Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main {
    private static final TasksWithNotEmptyRecevier tasks = new TasksWithNotEmptyRecevier();

    public static void offer(Exec exec) {
        tasks.offer(exec);
    }

    public static void main(String[] args) {
        Recevier<Boolean> execStatus = status -> {
            if (status) {
                tasks.exec();
            }
        };
        tasks.bindRecevier(execStatus);

        tasks.offer(LoginUI.getUI());
    }
}
