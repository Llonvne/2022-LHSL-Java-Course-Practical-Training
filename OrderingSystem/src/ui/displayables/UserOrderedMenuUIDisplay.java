package ui.displayables;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import ui.Displayable;


/**
 * 类名:     UserOrderedMenuUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class UserOrderedMenuUIDisplay implements Displayable {
    public String orderId;

    public UserOrderedMenuUIDisplay(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void display() {
        System.out.println("--------------- 订单 ---------------");
        System.out.println("序号       菜品编号       菜品       单价");
        for (ImmutableRecord record : new TableGetter("可用菜品表").getTable()) {
        }
    }
}
