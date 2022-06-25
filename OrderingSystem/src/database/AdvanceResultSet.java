package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 类名:     AdvanceResultSet
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AdvanceResultSet {
    private final ResultSet resultSet;
    private final Connection connection;
    private final Statement statement;

    public AdvanceResultSet(ResultSet resultSet, Connection connection, Statement statement) {
        this.resultSet = resultSet;
        this.connection = connection;
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void closeAll() throws SQLException {
        DatabaseConnection.closeAll(null, statement, resultSet);
    }
}
