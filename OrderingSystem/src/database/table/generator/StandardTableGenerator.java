package database.table.generator;

import database.record.constructor.recordConstructor.RecordConstructor;
import database.table.types.StandardTable;
import database.table.types.Table;

public class StandardTableGenerator implements TableGenerator{

    @Override
    public Table returnTable(String name,RecordConstructor recordConstructor) {
        return new StandardTable(name,recordConstructor);
    }
}
