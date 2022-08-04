package database2.proc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 类名:     ParserResultSetColumnProc
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class ParserResultSetColumnProc implements Proc<Collection<String>> {
    public ResultSet resultSet;

    public ParserResultSetColumnProc(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Collection<String> run() {
        LinkedList<String> columns = new LinkedList<String>();
        ResultSetMetaData metaData;
        try {
            metaData = resultSet.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columns.offer(metaData.getColumnName(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return columns;
    }
}
