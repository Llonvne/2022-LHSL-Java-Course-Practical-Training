package process.appointment;

import exec.Exec;
import exec.Tasks;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.UIOperations.UIOperationsWithSender;
import ui.displayables.AppointmentUIDisplay;

/**
 * 类名:     AppointmentTask
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AppointmentTask {
    public Tasks getTasks() {
        Exec form = new FormHandler(
            new AppointmentUIDisplay(),
            new UIOperations()
        );
        Tasks task = new Tasks();
        task.offer(form);
        return task;
    }
}
