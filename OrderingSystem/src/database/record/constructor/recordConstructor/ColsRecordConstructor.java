package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名:     ResultSetRecordConstructor
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class ColsRecordConstructor implements RecordConstructor {
    private final String[] cols;
    private final AttributesConstructor attributesConstructor;

    private final String tableName;

    public ColsRecordConstructor(AttributesConstructor attributesConstructor, String[] cols, String tableName) {
        this.attributesConstructor = attributesConstructor;
        this.tableName = tableName;
        this.cols = cols;
    }

    @Override
    public MuteableRecord generatorEmptyRecord() {

        MuteableRecord record = this.attributesConstructor.constructor(
            cols[0], cols
        );
        record.setTableName(this.tableName);
        return record;
    }
}
