package ui.UIOperations;

import exec.recall.Recevier;
import exec.recall.Sender;

/**
 * 类名:     UIOperationsWithSender
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class UIOperationsWithSender<E> extends UIOperations {
    private final Sender<E> sender = new Sender<>();

    public UIOperationsWithSender() {
    }

    public UIOperationsWithSender(Recevier<E> e) {
        sender.bindRecevier(e);
    }

    public UIOperationsWithSender(Recevier<E>[] e) {
        for (Recevier<E> recevier : e) {
            sender.bindRecevier(recevier);
        }
    }

    public void send(E e){
        sender.send(e);
    }
}
