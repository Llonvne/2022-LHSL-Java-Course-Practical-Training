package database.table;

import database.record.constructor.recordConstructor.OrderRecordConstructor;
import database.record.constructor.recordConstructor.RecordConstructor;
import database.record.constructor.attributesConstructor.StandardAttributesConstructor;
import database.table.generator.StandardTableGenerator;
import database.table.pool.generator.StandardTablePoolGenerator;
import database.table.types.Table;

public class TestTable {
    public static void main(String[] args) {
        TableFactory tableFactory = new TableFactory(new StandardTableGenerator(),new StandardTablePoolGenerator());
        RecordConstructor recordConstructor = new OrderRecordConstructor(new StandardAttributesConstructor());
        Table table = tableFactory.generaterTable("OrderNo",recordConstructor);
        System.out.println("你好世界");
    }
}
