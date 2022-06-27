package process.table;

import database.procs.GetAllTableType;
import database.procs.GetTableWaitingList;
import database.record.types.ImmutableRecord;
import database.table.types.ImmutableTable;
import ui.Displayable;

import java.util.List;

/**
 * 类名:     AvailableTableUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AvailableTableUIDisplay implements Displayable {
    @Override
    public void display() {
        List<String> types = new GetAllTableType().exec();
        for (String type : types){
            ImmutableTable records = new GetTableWaitingList(type).exec();
            for (ImmutableRecord record : records){
                System.out.println(record);
            }
        }
    }
}
