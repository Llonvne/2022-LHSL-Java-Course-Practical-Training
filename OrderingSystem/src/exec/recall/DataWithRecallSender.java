package exec.recall;

/**
 * 类名:     DataWithRecallSender
 * 描述:     该类组合 DataWithRecallReceiver 类，并自动管理 Sender 用于回调
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
// E 代表发送元素，R 表示返回元素
public class DataWithRecallSender<E, R> {

//    该类将自动建立并管理Sender
    private final Sender<R> sender = new Sender<>();

//    该类使用 DataWithRecallableRecevier 作为数据
    private final DataWithRecallableRecevier<E, R> dataWithRecallableRecevier;

//    使用 DataWithRecallableRecevier 构造 DataWithRecallSender
    public DataWithRecallSender
        (DataWithRecallableRecevier<E, R> dataWithRecallableRecevier) {
        this.dataWithRecallableRecevier = dataWithRecallableRecevier;
        sender.bindRecevier(dataWithRecallableRecevier.recallableReceiver);
    }

//    直接使用数据和回调 Recevier 构造 DataWithRecallSender
    public DataWithRecallSender(E e, Recevier<R> r) {
        this.dataWithRecallableRecevier = new DataWithRecallableRecevier<>(e, r);
        sender.bindRecevier(dataWithRecallableRecevier.recallableReceiver);
    }

//  Sender 接口
    public void send(R r) {
        sender.send(r);
    }

//  获得数据接口
    public E getData() {
        return dataWithRecallableRecevier.data;
    }
}
