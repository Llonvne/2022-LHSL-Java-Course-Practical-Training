package database.table.generator;

import database.record.constructor.recordConstructor.RecordConstructor;
import database.table.types.Table;

public interface TableGenerator {
    Table returnTable(String name,RecordConstructor recordConstructor);
}
