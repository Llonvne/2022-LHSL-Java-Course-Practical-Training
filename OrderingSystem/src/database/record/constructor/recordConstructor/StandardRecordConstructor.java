package database.record.constructor.recordConstructor;

import database.TableInfo;
import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

/**
 * 类名:     StandardRecordConstructor
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardRecordConstructor implements RecordConstructor {
    private final TableInfo tableInfo;
    private final AttributesConstructor attributesConstructor;

    public StandardRecordConstructor(AttributesConstructor attributesConstructor, TableInfo tableInfo) {
        this.attributesConstructor = attributesConstructor;
        this.tableInfo = tableInfo;
    }

    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor(tableInfo.primaryKey(), tableInfo.keys());
        record.setTableName(tableInfo.tableName());
        return record;
    }
}
