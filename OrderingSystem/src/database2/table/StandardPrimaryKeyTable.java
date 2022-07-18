package database2.table;

import database2.exception.DatabaseExecption;
import database2.exception.KeyNotFoundException;
import database2.exception.ValueNotFoundException;
import database2.keyPair.KeyPair;
import database2.keyPair.StandardKeyPair;
import database2.record.Record;

import java.util.Collection;

/**
 * 类名:     StandardPrimaryKeyTable
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardPrimaryKeyTable<K, V,
    E extends KeyPair<K, V>,
    R extends Record<K, V, E>> extends StandardTable<K, V, E, R>
    implements PrimaryKeyTable<K, V, E, R> {

    private final K primaryKey;

    public StandardPrimaryKeyTable(String tableName, K primaryKey) {
        super(tableName);
        this.primaryKey = primaryKey;
    }

    public StandardPrimaryKeyTable(String tableName, K primaryKey, Collection<R> collection) {
        super(tableName, collection);
        this.primaryKey = primaryKey;
    }

    @Override
    public K getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public Record<K, V, E> searchByPrimaryKey(V v) throws KeyNotFoundException, ValueNotFoundException {
        for (var record : searchByAttribute(new StandardKeyPair<>(primaryKey, v))) {
            return record;
        }
        throw new ValueNotFoundException(primaryKey, v);
    }
}
