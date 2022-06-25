package database.record.constructor.attributesConstructor;

import database.record.types.MuteableRecord;

// 这个接口定义属性如何被构造成 MuteableRecord
public interface AttributesConstructor {
    MuteableRecord constructor(String primaryKey,String[] attributes);
}
