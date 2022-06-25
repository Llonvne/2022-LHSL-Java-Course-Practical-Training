package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

public class TableRecordConstructor implements RecordConstructor{

    private final AttributesConstructor attributesConstructor;

    public TableRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("table_type",
                new String[]{"table_type","table_number","remarks"});
        record.setTableName("Table");
        return record;
    }
}
