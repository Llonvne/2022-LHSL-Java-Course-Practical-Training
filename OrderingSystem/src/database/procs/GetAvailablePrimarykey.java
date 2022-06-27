package database.procs;

import database.sqlTools.AdvanceResultSet;
import database.sqlTools.QueryExecute;

import java.sql.SQLException;

/**
 * 类名:     GetAvailablePrimarykey
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetAvailablePrimarykey implements Proc<Integer> {
    private final String tableName;
    private final String primaryKey;

    public GetAvailablePrimarykey(String tableName, String primaryKey) {
        this.primaryKey = primaryKey;
        this.tableName = tableName;
    }

    @Override
    public Integer exec() {
        String sql = "SELECT MAX(CAST(" + primaryKey + " as UNSIGNED)) as pri FROM " + tableName;
        AdvanceResultSet resultSet = QueryExecute.executeQuery(sql);
        String id = "";
        try {
            while (resultSet.getResultSet().next()) {
                id = resultSet.getResultSet().getString("pri");
            }
            resultSet.closeAll();
        } catch (SQLException e) {
            throw new RuntimeException("数据集解析异常");
        }
        return Integer.parseInt(id) + 1;
    }
}
