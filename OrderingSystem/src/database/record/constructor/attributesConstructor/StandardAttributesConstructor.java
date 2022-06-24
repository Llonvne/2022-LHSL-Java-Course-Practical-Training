package database.record.constructor.attributesConstructor;

import database.record.types.MuteableRecord;
import database.record.types.Record;

public class StandardAttributesConstructor implements AttributesConstructor{

    @Override
    public MuteableRecord constructor(String primaryKey, String[] attributes) {
        return Record.generateEmptyRecord(primaryKey,attributes);
    }
}
