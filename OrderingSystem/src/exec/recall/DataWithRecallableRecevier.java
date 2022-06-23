package exec.recall;

/**
 * 类名:     DataWithRecallableRecevier
 * 描述:     该类将数据类型与回调Receiver组合。
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class DataWithRecallableRecevier<E, R> {
    public E data;
    public Recevier<R> recallableReceiver;

    public DataWithRecallableRecevier(E data, Recevier<R> recevier) {
        this.data = data;
        this.recallableReceiver = recevier;
    }
}
