package database.table.types;

import database.keyValue.KeyPair;
import database.record.constructor.recordConstructor.RecordConstructor;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * 类名:     ResultSetBasedTable
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class ResultSetBasedTable implements ImmutableTable {

    private final String name;

    private final LinkedList<ImmutableRecord> records = new LinkedList<>();

    private final ImmutableRecord emptyRecord;

    public ResultSetBasedTable(String name, RecordConstructor recordConstructor, ResultSet resultSet) {
        this.name = name;
        this.emptyRecord = recordConstructor.generatorEmptyRecord();
        try {
            while (resultSet.next()) {
                MuteableRecord record = recordConstructor.generatorEmptyRecord();
                for (String key : recordConstructor.generatorEmptyRecord().getKeys()) {
                    record.updateAttribute(new KeyPair<>(key, resultSet.getString(key)));
                }
                this.records.offer(record);
            }
        } catch (SQLException e) {
            throw new RuntimeException("解析结果集错误");
        }
    }

    @Override
    public boolean contains(ImmutableRecord e) {
        for (ImmutableRecord record : records) {
            if (record.getAttribute(e.getPrimaryKey()).getValue().equals(
                e.getAttribute(e.getPrimaryKey()).getKey()
            )) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ImmutableRecord getRecordByPrimaryKey(String primaryKey) {
        for (ImmutableRecord record : records) {
            if (record.getAttribute(emptyRecord.getPrimaryKey()).getValue().equals(
                primaryKey
            )) {
                return record;
            }
        }
        throw new RuntimeException("该主键记录不存在");
    }

    @Override
    public String tableName() {
        return name;
    }

    @Override
    public Iterator<ImmutableRecord> iterator() {
        return this.records.iterator();
    }
}
