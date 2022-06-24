package database.record.types;

import database.record.MuteableRecord;
import database.record.Record;

public class OrderRecordConstructor implements RecordConstructor{
    @Override
    public MuteableRecord generatorEmptyRecord() {
        return Record.generateEmptyRecord("OrderNo",
                new String[]{"OrderNo","CustomerName","CustomerStatus","ReserveNo","MenuNo","Payment","IsPaid","PhoneNumber"});
    }
}
