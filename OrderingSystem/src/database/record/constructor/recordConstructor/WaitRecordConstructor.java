package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

public class WaitRecordConstructor implements RecordConstructor{

    private final AttributesConstructor attributesConstructor;

    public WaitRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("wait_name",
                new String[]{"wait_name","start_time","wait_table","wait_status","remarks"});
        record.setTableName("Wait");
        return record;
    }
}
