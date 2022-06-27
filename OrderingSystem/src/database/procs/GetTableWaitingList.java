package database.procs;

import database.DatabaseHandler;
import database.sqlTools.AdvanceResultSet;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;

/**
 * 类名:     GetTableWaitingList
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetTableWaitingList implements Proc<ImmutableTable> {
    private final String type;

    public GetTableWaitingList(String type) {
        this.type = type;
    }

    @Override
    public ImmutableTable exec() {
        String sqlTemplate = "call 可用桌型('%s')";
        AdvanceResultSet resultSet = QueryExecute.executeQuery(
            String.format(sqlTemplate, type)
        );
        return DatabaseHandler.getInstance().getDatabaseHandler()
            .getResultSetTable("等待桌型" + type, resultSet);
    }
}
