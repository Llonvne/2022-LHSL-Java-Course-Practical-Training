package database.commonOperations;

import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.record.types.MuteableRecord;
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
public class InsertOperations implements Exec {
    private final Table table;

    public InsertOperations(Table table) {
        this.table = table;
    }

    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);
        MuteableRecord newRecord = table.getEmptyRecord();
        for (String key : table.getEmptyRecord().getKeys()) {
            if (key.equals(table.getEmptyRecord().getPrimaryKey())) {
                continue;
            }
            System.out.print("请输入 " + key + " 的值 >> ");
            String value = scanner.next();
            newRecord.updateAttribute(new KeyPair<>(key, value));
        }
        newRecord.updateAttribute(
            new KeyPair<>(
                newRecord.getPrimaryKey(),
                String.valueOf
                    (new GetAvailablePrimarykey(table.tableName(), newRecord.getPrimaryKey()).exec())
            ));
        table.insertRecord(newRecord);
    }
}
