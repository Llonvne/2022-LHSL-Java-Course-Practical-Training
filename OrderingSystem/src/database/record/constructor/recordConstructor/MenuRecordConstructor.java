package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

public class MenuRecordConstructor implements RecordConstructor{
    private final AttributesConstructor attributesConstructor;
    public MenuRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("dish_number",
                new String[]{"dish_number","dish_name","dish_description","dish_price","other","remain_quantity"});
        record.setTableName("Menu");
        return record;
    }
}

