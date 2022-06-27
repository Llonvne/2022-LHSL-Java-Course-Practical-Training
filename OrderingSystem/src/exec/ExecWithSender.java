package exec;

import exec.recall.Recevier;

/**
 * 类名:     ExecWithSender
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public abstract class ExecWithSender implements Exec {
    private final Recevier<Exec> sender;
    public ExecWithSender(Recevier<Exec> sender) {
        this.sender = sender;
    }
    public final Recevier<Exec> getSender() {
        return sender;
    }
    public final void send(Exec exec) {
        this.sender.toRecevier(exec);
    }
}
