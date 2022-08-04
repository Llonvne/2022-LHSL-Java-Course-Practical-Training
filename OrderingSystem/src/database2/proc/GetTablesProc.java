package database2.proc;

import database2.exception.DatabaseExecption;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 类名:     GetAllTableProc
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetTablesProc implements Proc<Collection<String>> {
    private final String databaseName;
    private final Connection connection;

    private final Type type;

    public GetTablesProc(String databaseName, Type type, Connection connection) {
        this.databaseName = databaseName;
        this.connection = connection;
        this.type = type;
    }

    public enum Type {
        TABLE, VIEW
    }

    @Override
    public Collection<String> run() throws DatabaseExecption {
        LinkedList<String> tables = new LinkedList<>();
        DatabaseMetaData metaData;
        try {
            metaData = connection.getMetaData();
        } catch (SQLException e) {
            throw new DatabaseExecption("元数据获取失败");
        }

        String target = "VIEW";
        if (type == Type.TABLE) {
            target = "TABLE";
        }

        try (ResultSet resultSet = metaData.getTables(databaseName, null, null, new String[]{target})) {
            ResultSetMetaData resMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                tables.offer(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new DatabaseExecption("表名获取失败");
        }
        return tables;
    }
}
