package ui.displayables;

import database.record.types.ImmutableRecord;
import process.menu.AvailableMenu;
import process.menu.Menu;
import ui.Displayable;
import ui.FormHandler;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 类名:     AvailableMenuUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AvailableMenuUIDisplay implements Displayable {
    private final Menu menu;

    public AvailableMenuUIDisplay(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void display() {
        System.out.println("--------------- 所有可用菜单 ---------------");
        System.out.println("序号        菜品        描述        单价");
        for (ImmutableRecord record : menu){
            System.out.println(record.getAttribute("dish_name").getValue());
            System.out.println(record.getAttribute("dish_description").getValue());
            System.out.println(record.getAttribute("dish_price").getValue());
        }
        System.out.println("--------------- 祝您用餐愉快！ ---------------");
    }


}
