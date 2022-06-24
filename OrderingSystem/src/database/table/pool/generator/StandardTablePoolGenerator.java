package database.table.pool.generator;

import database.table.pool.StandardTablePool;
import database.table.pool.TablePool;

public class StandardTablePoolGenerator implements TablePoolGenerator{
    @Override
    public TablePool generatorTablePool() {
        return new StandardTablePool();
    }
}
