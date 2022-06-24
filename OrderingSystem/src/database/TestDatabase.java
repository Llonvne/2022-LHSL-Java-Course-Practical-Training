package database;

import database.record.constructor.attributesConstructor.StandardAttributesConstructor;
import database.record.constructor.recordConstructor.OrderRecordConstructor;
import database.record.types.MuteableRecord;
import database.table.types.Table;
import database.unifiedDatabaseOperations.UnifiedDatabaseOperations;

public class TestDatabase {
    public static void main(String[] args) {
        UnifiedDatabaseOperations handler = DatabaseHandler.getInstance().getDatabaseHandler();
        Table table = handler.createTable("OrderNo",new OrderRecordConstructor(new StandardAttributesConstructor()));

        MuteableRecord record = handler.getTable("OrderNo").getEmptyRecord();
        record.updateAttribute(new KeyPair<>("OrderNo","12345"));
        handler.insertRecord(record);
    }
}