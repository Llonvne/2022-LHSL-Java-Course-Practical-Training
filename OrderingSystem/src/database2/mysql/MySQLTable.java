package database2.mysql;

import database2.exception.KeyNotFoundException;
import database2.keyPair.KeyPair;
import database2.record.Record;
import database2.table.Table;

import java.util.Iterator;

/**
 * 类名:     MySQLTable
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class MySQLTable<K,V,E extends KeyPair<K, V>,R extends Record<K, V, E>> implements Table<K,V,E,R> {
    @Override
    public void insert(R r) {

    }

    @Override
    public boolean contains(R r) {
        return false;
    }

    @Override
    public Table<K, V, E, R> searchByAttribute(KeyPair<K, V> attribute) throws KeyNotFoundException {
        return null;
    }

    @Override
    public Iterator<R> iterator() {
        return null;
    }
}
