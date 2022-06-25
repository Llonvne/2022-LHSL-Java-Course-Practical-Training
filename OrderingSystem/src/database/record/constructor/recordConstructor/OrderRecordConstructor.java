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
        MuteableRecord record = attributesConstructor.constructor("Order_number",
                new String[]{"customer_status","appointment_number","menu_number","table_number","payment_method","Payment_status","phone_number","waiting_number"});
        record.setTableName("Orders");
        return record;
    }
}
