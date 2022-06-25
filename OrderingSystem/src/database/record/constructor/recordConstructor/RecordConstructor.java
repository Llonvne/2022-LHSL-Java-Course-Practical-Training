package database.record.constructor.recordConstructor;

import database.record.types.MuteableRecord;

// 该处将负责构造符合标准的空记录
public interface RecordConstructor {
    MuteableRecord generatorEmptyRecord();
}
