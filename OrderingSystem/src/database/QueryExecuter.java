package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 类名:     QueryExecuter
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class QueryExecuter {
    public static AdvanceResultSet executeQuery(String sql) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("use OrderingSystem");
        ResultSet result = stmt.executeQuery(sql);
        return new AdvanceResultSet(result, connection, stmt);
    }

    public static void execute(String sql) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("use OrderingSystem");
        stmt.execute(sql);
        stmt.close();
    }
}
