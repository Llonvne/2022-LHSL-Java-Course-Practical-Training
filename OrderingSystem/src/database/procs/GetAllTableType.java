package database.procs;

import database.DatabaseHandler;
import database.record.types.ImmutableRecord;
import database.sqlTools.AdvanceResultSet;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;

import java.util.LinkedList;
import java.util.List;

/**
 * 类名:     GetAllTableType
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetAllTableType implements Proc<List<String>>{

    @Override
    public List<String> exec() {
        String sqlTemplate = "CALL 所有桌型()";
        AdvanceResultSet resultSet = QueryExecute.executeQuery(sqlTemplate);
        ImmutableTable table = DatabaseHandler.getInstance().getDatabaseHandler()
            .getResultSetTable("所有可用桌型",resultSet);
        List<String> tableTypes = new LinkedList<>();
        for (ImmutableRecord record : table){
            tableTypes.add(record.getAttribute("桌型").getValue());
        }
        return tableTypes;
    }
}
