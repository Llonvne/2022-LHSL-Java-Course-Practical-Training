package exec.recall;

import java.util.LinkedList;

/**
 * 类名:     Recall
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public final class Sender<E> {
    private final LinkedList<Recevier<E>> receivers = new LinkedList<>();

    public void bindRecevier(Recevier<E> e) {
        if (receivers.contains(e)) {
            return;
        }
        receivers.offer(e);
    }

    public boolean contains(Recevier<E> e) {
        return receivers.contains(e);
    }

    public boolean remove(Recevier<E> e) {
        if (contains(e)) {
            receivers.remove(e);
            return true;
        }
        return false;
    }

    public void send(E e) {
        for (Recevier<E> recevier : receivers) {
            recevier.toRecevier(e);
        }
    }
}
