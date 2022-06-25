package ui.displayables;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import ui.Displayable;

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

    @Override
    public void display() {
        System.out.println("--------------- 所有可用菜单 ---------------");
        System.out.println("序号        菜品        描述        单价");
        for (ImmutableRecord record : new TableGetter("菜品表").getTable()){
            System.out.print("\trecord.getAttribute('dish_name').getValue()");
            System.out.print("\trecord.getAttribute('dish_description').getValue()");
            System.out.print("\trecord.getAttribute('dish_price').getValue()");
        }
        System.out.println("--------------- 祝您用餐愉快！ ---------------");
    }
}
