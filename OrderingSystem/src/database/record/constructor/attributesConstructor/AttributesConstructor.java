package database.record.constructor.attributesConstructor;

import database.record.types.MuteableRecord;

public interface AttributesConstructor {
    MuteableRecord constructor(String primaryKey,String[] attributes);
}
