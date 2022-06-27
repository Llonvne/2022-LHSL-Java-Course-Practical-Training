package process.order;

import ui.Displayable;

/**
 * 类名:     NewOrderUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class NewOrderUIDisplay implements Displayable {
    @Override
    public void display() {
        System.out.println("--------------");
        System.out.println("1. 新的订单");
        System.out.println("2. 已有订单");
        System.out.print(">>>");
    }
}
