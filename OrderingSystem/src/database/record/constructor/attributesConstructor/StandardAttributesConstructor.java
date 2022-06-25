package database.record.constructor.attributesConstructor;

import database.record.types.MuteableRecord;
import database.record.types.Record;

// 这是标准的属性构造器，将调用标准Record类提供的属性构造方法
public class StandardAttributesConstructor implements AttributesConstructor{

    @Override
    public MuteableRecord constructor(String primaryKey, String[] attributes) {
        return Record.generateEmptyRecord(primaryKey,attributes);
    }
}
