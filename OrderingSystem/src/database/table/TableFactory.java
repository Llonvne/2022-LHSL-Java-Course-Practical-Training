package database.table;

import database.record.constructor.recordConstructor.RecordConstructor;
import database.table.generator.TableGenerator;
import database.table.pool.TablePool;
import database.table.pool.generator.TablePoolGenerator;
import database.table.types.Table;

public class TableFactory implements TableGetter{
    private final TableGenerator tableGenerator;
    private final TablePool pools;

    public TableFactory(TableGenerator tableGenerator, TablePoolGenerator tablePoolGenerator){
        this.tableGenerator = tableGenerator;
        this.pools = tablePoolGenerator.generatorTablePool();
    }

    public TablePool getPools(){
        return pools;
    }

    public Table generaterTable(String name,RecordConstructor recordConstructor){
        Table table = tableGenerator.returnTable(name,recordConstructor);
        pools.insertTable(table);
        return table;
    }

    public Table getTable(String tableName){
        return pools.getTable(tableName);
    }
}
