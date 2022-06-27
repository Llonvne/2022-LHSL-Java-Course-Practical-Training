package process.menu;

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
        System.out.println("序号    菜品        描述        单价     类别");
        for (ImmutableRecord record : new TableGetter("菜品表").getTable()){
            System.out.printf("%-6s%-10s%-10s%-6s%-4s\n",
                    record.getAttribute("菜品编号").getValue(),
                    record.getAttribute("菜品名").getValue(),
                    record.getAttribute("菜品描述").getValue(),
                    record.getAttribute("价格").getValue(),
                    record.getAttribute("其他").getValue());
        }
        System.out.println("--------------- 祝您用餐愉快！ ---------------");
    }
}
