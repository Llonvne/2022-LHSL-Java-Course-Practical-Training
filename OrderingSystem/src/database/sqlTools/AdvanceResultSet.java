package database.sqlTools;

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
// 提供了保存了 ResultSet 和 Statement 和 Connection 的 ResultSet，负责关闭资源
public class AdvanceResultSet {
    private final ResultSet resultSet;
    private final Statement statement;

    public AdvanceResultSet(ResultSet resultSet, Statement statement) {
        this.resultSet = resultSet;
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void closeAll() throws SQLException {
        DatabaseConnection.closeAll(null, statement, resultSet);
    }
}
