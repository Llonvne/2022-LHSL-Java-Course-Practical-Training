package database.commonOperations;

import database.keyValue.KeyPair;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.Table;
import exec.Exec;
import ui.UIOperations.UIOperations;

import java.util.Scanner;

/**
 * 类名:     UpdateOperations
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class UpdateOperations implements Exec {
    public final Table table;

    public UpdateOperations(Table table) {
        this.table = table;
    }

    @Override
    public void exec() {
        displayTable(table);

        System.out.print
            ("请输入要修改记录的主键 (" + table.getEmptyRecord().getPrimaryKey() + ") >>>");
        Scanner scanner = new Scanner(System.in);
        String primaryKey = scanner.next();

        System.out.println("请输入新的记录");
        String value;
        MuteableRecord newRecord = table.getEmptyRecord();
        for (String key : table.getEmptyRecord().getKeys()) {
            System.out.print("请输入 " + key + " 键的值 >>>");
            value = scanner.next();
            newRecord.updateAttribute(new KeyPair<>(key, value));
        }

        table.updateRecord(newRecord);
    }

    public static void displayTable(Table table) {
        for (String key : table.getEmptyRecord().getKeys()) {
            System.out.print(key + "\t\t\t");
        }
        System.out.println();
        for (ImmutableRecord r : table) {
            for (String key : r.getKeys()) {
                System.out.print(r.getAttribute(key).getValue() + "\t\t\t");
            }
            System.out.println();
        }
    }
}
