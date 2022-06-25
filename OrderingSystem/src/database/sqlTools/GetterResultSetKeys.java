package database.sqlTools;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名:     GetterResultSetKeys
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetterResultSetKeys {
    public String[] getResultSetKeys(ResultSet resultSet) {
        List<String> cols = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                String columnName = rsmd.getColumnName(i).toLowerCase();
                cols.add(columnName);
            }
            return cols.toArray(new String[0]);
        } catch (SQLException e) {
            throw new RuntimeException("数据集解析错误！");
        }
    }
}
