package database;

import database.keyValue.KeyPair;
import database.record.constructor.attributesConstructor.StandardAttributesConstructor;
import database.record.constructor.recordConstructor.MenuRecordConstructor;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.Table;
import database.unifiedDatabaseOperations.UnifiedDatabaseOperations;

import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args) throws SQLException {
        UnifiedDatabaseOperations handler = DatabaseHandler.getInstance().getDatabaseHandler();
//        Table table = handler.createTable("OrderNo",new OrderRecordConstructor(new StandardAttributesConstructor()));
//
//        MuteableRecord record = handler.getTable("OrderNo").getEmptyRecord();
//        record.updateAttribute(new KeyPair<>("Customer","华邵钶"));
//        handler.insertRecord(record);

//        MuteableRecord record1 = new Record("123");
//        record1.setTableName("OrderNo");
//        handler.insertRecord(record1);

        Table table1 = handler.createTable("Menu",new MenuRecordConstructor(new StandardAttributesConstructor()));
        for (ImmutableRecord r : table1) {
            System.out.println(r.getAttribute("dish_name"));
        }

        MuteableRecord r1 = table1.getEmptyRecord();
        r1.updateAttribute(new KeyPair<>("dish_number","21"));
        r1.updateAttribute(new KeyPair<>("dish_name","小炒肉"));
        r1.updateAttribute(new KeyPair<>("dish_description","农家小炒肉"));
        r1.updateAttribute(new KeyPair<>("dish_price","68"));
        r1.updateAttribute(new KeyPair<>("other","肉类"));
        r1.updateAttribute(new KeyPair<>("remain_quantity","500"));

//        handler.insertRecord(r1);
//        handler.update(r1);
//        System.out.println(handler.contains(r1));
    }
}