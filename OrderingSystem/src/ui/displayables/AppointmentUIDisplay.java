package ui.displayables;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import ui.Displayable;

/**
 * 类名:     AppointmentUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AppointmentUIDisplay implements Displayable {
    @Override
    public void display() {
        System.out.println("--------------- 所有预约顾客 ---------------");
        System.out.println("预约客户姓名      预约时间      预约号      电话号码      备注    是否有效");
        for (ImmutableRecord record : new TableGetter("预约表").getTable()){
            System.out.println(
                    record.getAttribute("预约客户姓名").getValue() + "\t\t"+
                    record.getAttribute("预约时间").getValue() + "\t\t"+
                    record.getAttribute("预约号").getValue() + "\t\t"+
                    record.getAttribute("电话号码").getValue() + "\t\t"+
                    record.getAttribute("备注").getValue() + "\t\t"+
                    record.getAttribute("是否有效").getValue() + "\t");
        }
        System.out.println("--------------- 祝您用餐愉快！ ---------------");
    }
}
