package database;

import database.record.constructor.attributesConstructor.StandardAttributesConstructor;
import database.record.constructor.recordConstructor.OrderRecordConstructor;
import database.record.types.MuteableRecord;
import database.record.types.Record;
import database.table.types.Table;
import database.unifiedDatabaseOperations.UnifiedDatabaseOperations;

public class TestDatabase {
    public static void main(String[] args) {
        UnifiedDatabaseOperations handler = DatabaseHandler.getInstance().getDatabaseHandler();
        Table table = handler.createTable("OrderNo",new OrderRecordConstructor(new StandardAttributesConstructor()));

        MuteableRecord record = handler.getTable("OrderNo").getEmptyRecord();
        record.updateAttribute(new KeyPair<>("Customer","华邵钶"));
        handler.insertRecord(record);

        MuteableRecord record1 = new Record("123");
        record1.setTableName("OrderNo");
        handler.insertRecord(record1);
    }
}