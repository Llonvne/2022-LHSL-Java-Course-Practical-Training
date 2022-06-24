package database.record.constructor.recordConstructor;

import database.record.types.MuteableRecord;
import database.record.constructor.attributesConstructor.AttributesConstructor;

public class OrderRecordConstructor implements RecordConstructor{
    private final AttributesConstructor attributesConstructor;
    public OrderRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("OrderNo",
                new String[]{"OrderNo","CustomerName","CustomerStatus","ReserveNo","MenuNo","Payment","IsPaid","PhoneNumber"});
        record.setTableName("OrderTable");
        return record;
    }
}
