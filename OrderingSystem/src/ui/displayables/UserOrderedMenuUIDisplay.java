package ui.displayables;

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

    }
}
