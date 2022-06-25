package database;

import database.keyValue.KeyPair;
import database.record.constructor.attributesConstructor.StandardAttributesConstructor;
import database.record.constructor.recordConstructor.StandardRecordConstructor;
import database.record.types.ImmutableRecord;
import database.sqlTools.AdvanceResultSet;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;
import database.table.types.Table;
import database.unifiedDatabaseOperations.UnifiedDatabaseOperations;
import exec.Exec;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 类名:     Init
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Init implements Exec {
    private final String databasename;

    public Init(String databasename) {
        this.databasename = databasename;
    }

    public static void initDatabase(String databasename) throws SQLException {

//        尝试获取数据库所有表名
        AdvanceResultSet resultSet = QueryExecute.executeQuery("select table_name from information_schema.tables where table_schema='" + databasename + "'");
        LinkedList<String> tableNames = new LinkedList<>();
        while (resultSet.getResultSet().next()) {
            tableNames.offer(resultSet.getResultSet().getString("table_name"));
        }
        resultSet.closeAll();

        if (tableNames.size() == 0) {
            throw new IllegalArgumentException("数据表数量为0");
        }

//      存储表信息
        LinkedList<TableInfo> tableInfos = new LinkedList<>();

//        尝试获得每张表的主键名和所有字段名
        LinkedList<String> keyName;
        for (String tableName : tableNames) {

//          尝试获得字段名称
            keyName = new LinkedList<>();
            AdvanceResultSet keysResultSet = QueryExecute.executeQuery("select column_name from information_schema.columns where table_schema='" + databasename + "' and table_name='" + tableName + "';");
            while (keysResultSet.getResultSet().next()) {
                keyName.offer(keysResultSet.getResultSet().getString("column_name"));
            }
            keysResultSet.closeAll();

//          尝试获得主键
            AdvanceResultSet primaryKey = QueryExecute.executeQuery("SELECT TABLE_NAME,COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME<> 'dtproperties' and TABLE_NAME = '" + tableName + "' AND table_schema = '" + databasename + "'");
            String primary = "";
            while (primaryKey.getResultSet().next()) {
                primary = primaryKey.getResultSet().getString("COLUMN_NAME");
            }
            primaryKey.closeAll();

//          添加到表信息
            tableInfos.offer(new TableInfo(tableName, primary, keyName.toArray(new String[0])));
        }

//      建立表对应信息库
        UnifiedDatabaseOperations handler = DatabaseHandler.getInstance().getDatabaseHandler();
        for (TableInfo tableinfo : tableInfos) {
            handler.createTable(tableinfo.getTableName(), new StandardRecordConstructor(
                new StandardAttributesConstructor(), tableinfo
            ));
        }
    }

    @Override
    public void exec() {
        try {
            initDatabase(this.databasename);
        } catch (SQLException e) {
            throw new RuntimeException("数据库链接失败！");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("数据库名有误！");
        }
    }
}
