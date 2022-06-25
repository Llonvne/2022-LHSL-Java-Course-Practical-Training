package database;

import database.record.types.MuteableRecord;
import database.table.types.Table;
import exec.recall.DataWithRecallSender;
import exec.recall.Recevier;
import exec.recall.Sender;

/**
 * 类名:     RecordGetter
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TableGetter {
    private final Sender<DataWithRecallSender<String, Table>> sender = new Sender<>();

    private Table targetTable;

    public TableGetter(String tableName) {
        sender.bindRecevier(DatabaseHandler.getInstance().getDatabaseReceiver());

        Recevier<Table> tableRecevier = immutableRecords -> targetTable = immutableRecords;
        sender.send(new DataWithRecallSender<>(tableName, tableRecevier));
    }

    public Table getTable() {
        return targetTable;
    }
}
