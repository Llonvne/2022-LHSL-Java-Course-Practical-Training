package database2;

import database2.mysql.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * 类名:     Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        try (Statement stat = DatabaseConnection.getConnection().createStatement();) {
            stat.execute("use OrderingSystem");
            String sql = "SELECT * FROM 员工表";
        }
    }
}
