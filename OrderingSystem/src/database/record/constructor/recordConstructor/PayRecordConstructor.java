package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

public class PayRecordConstructor implements RecordConstructor{

    private final AttributesConstructor attributesConstructor;

    public PayRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("payment_method",
                new String[]{"payment_method","remarks"});
        record.setTableName("Pay");
        return record;
    }
}
