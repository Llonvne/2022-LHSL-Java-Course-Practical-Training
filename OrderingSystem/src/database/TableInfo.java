package database;

/**
 * 类名:     TableInfo
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TableInfo {
    private final String tableName;
    private final String primaryKey;
    private final String[] keys;

    public TableInfo(String tableName, String primaryKey, String[] keys) {
        this.tableName = tableName;
        this.primaryKey = primaryKey;
        this.keys = keys;
    }

    public String getTableName() {
        return tableName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public String[] getKeys() {
        return keys;
    }
}
