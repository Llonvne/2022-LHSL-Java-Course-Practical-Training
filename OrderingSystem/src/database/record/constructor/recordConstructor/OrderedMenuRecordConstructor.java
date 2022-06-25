package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

public class OrderedMenuRecordConstructor implements RecordConstructor{

    private final AttributesConstructor attributesConstructor;

    public OrderedMenuRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("order_number",
                new String[]{"order_number","dish_number","copies_number","remarks"});
        record.setTableName("OrderedMenu");
        return record;
    }
}