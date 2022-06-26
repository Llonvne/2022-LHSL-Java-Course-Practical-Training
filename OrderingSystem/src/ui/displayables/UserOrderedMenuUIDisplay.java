package ui.displayables;

import database.procs.GetUserOrderedMenu;
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
        System.out.println("------------------- 订单 -------------------");
        System.out.println("价格      份数      菜品名      菜品编号");
        double total = 0;
        for (ImmutableRecord record : new GetUserOrderedMenu(orderId).exec()) {
            System.out.println(record.getAttribute("价格").getValue() + "\t\t"
                    + record.getAttribute("份数").getValue() + "\t\t"
                    + record.getAttribute("菜品名").getValue() + "\t\t"
                    + record.getAttribute("菜品编号").getValue() + "\t");
            total += Double.parseDouble(record.getAttribute("价格").getValue());
        }
        System.out.println("");
        System.out.println("您一共消费 " + total + " 元");
        System.out.println("----------------- 欢迎下次光临 -----------------");
    }
}
