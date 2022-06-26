package process.admin;

import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;

/**
 * 类名:     AdminModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AdminModule extends ExecWithSender {
    public AdminModule(Recevier<Exec> sender) {
        super(sender);
    }

    @Override
    public void exec() {

    }
}
