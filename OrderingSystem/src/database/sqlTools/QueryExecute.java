package database.sqlTools;

import database.DatabaseConnection;

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

public class QueryExecute {
    public static AdvanceResultSet executeQuery(String sql) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute("use OrderingSystem");
            ResultSet result = stmt.executeQuery(sql);
            return new AdvanceResultSet(result, stmt);
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询执行失败");
        }
    }

    public static void execute(String sql) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute("use OrderingSystem");
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询执行失败");
        }
    }
}
