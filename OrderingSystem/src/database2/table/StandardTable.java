package database2.table;

import database2.exception.DatabaseExecption;
import database2.exception.KeyNotFoundException;
import database2.keyPair.KeyPair;
import database2.record.Record;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 类名:     StandardTable
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardTable
    <K, V,
        E extends KeyPair<K, V>,
        R extends Record<K, V, E>>
    implements Table<K, V, E, R> {

    private final Collection<R> records;

    private final String tableName;

    public StandardTable(String tableName, Collection<R> records) {
        this.records = records;
        this.tableName = tableName;
    }

    public StandardTable(String tableName) {
        this.records = new LinkedList<>();
        this.tableName = tableName;
    }

    @Override
    public void insert(R r) {
        records.add(r);
    }

    @Override
    public boolean contains(R r) {
        return records.contains(r);
    }

    @Override
    public Table<K, V, E, R> searchByAttribute(KeyPair<K, V> attribute) throws KeyNotFoundException {
        Table<K, V, E, R> res = new StandardTable<>(tableName + " 基于 " + attribute + " 查询的结果集合");

        for (R r : records) {
            K k = attribute.getKey();
            if (r.getValue(k).equals(attribute.getValue())) {
                res.insert(r);
            }
        }
        return res;
    }

    @Override
    public Iterator<R> iterator() {
        return records.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("表名").append(tableName).append("\n");
        for (R r : records) {
            sb.append(r).append("\n");
        }
        return sb.toString();
    }
}
