package ui.displayables;

import database.record.types.ImmutableRecord;
import process.menu.Menu;
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
    private Menu menu;
    private String order_number;

    public UserOrderedMenuUIDisplay(Menu menu, String order_number) {
        this.menu = menu;
        this.order_number = order_number;
    }

    @Override
    public void display() {
        System.out.println("--------------- 订单 ---------------");
        System.out.println("序号       菜品编号       菜品       单价");
        for (ImmutableRecord record: menu){
            System.out.print(record.getAttribute("order_number").getValue());
            System.out.print(record.getAttribute("dish_number").getValue());
        }
        System.out.println(order_number + menu + menu.getPrice());
    }
}
