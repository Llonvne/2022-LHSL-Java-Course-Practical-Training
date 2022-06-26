package ui.displayables;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import ui.Displayable;

/**
 * 类名:     TodayAppointmentUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TodayAppointmentUIDisplay implements Displayable {

    @Override
    public void display() {
        for (ImmutableRecord record : new TableGetter("当日预约").getTable()){
            System.out.println(record);
        }
    }
}
