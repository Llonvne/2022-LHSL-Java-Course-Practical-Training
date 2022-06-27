package process.waiting;

import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;

/**
 * 类名:     WaitingModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class WaitingModule extends ExecWithSender {
    private String orderId;

    public WaitingModule(Recevier<Exec> sender, String orderId) {
        super(sender);
        this.orderId = orderId;
    }

    @Override
    public void exec() {

    }
}
