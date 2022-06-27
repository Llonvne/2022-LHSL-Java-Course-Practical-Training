package database.commonOperations;

import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.sqlTools.CopyRecord;
import database.table.types.Table;
import exec.Exec;

import java.util.Scanner;

/**
 * 类名:     InsertOperations
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class DeleteOperations implements Exec {
    private final Table table;

    public DeleteOperations(Table table) {
        this.table = table;
    }

    @Override
    public void exec() {
        UpdateOperations.displayTable(table);

        System.out.println("请输入要删除的记录" + table.getEmptyRecord().getPrimaryKey() + " >>>");
        Scanner scanner = new Scanner(System.in);
        String primaryKey = scanner.next();
        ImmutableRecord record = table.getRecordByPrimaryKey(primaryKey);
        table.remove(record);
    }
}
