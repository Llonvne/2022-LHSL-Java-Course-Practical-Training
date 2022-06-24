package database.table.pool;

import database.table.types.Table;

import java.util.Iterator;
import java.util.TreeMap;

public class StandardTablePool implements TablePool{
    private final TreeMap<String,Table> map = new TreeMap<>();
    @Override
    public boolean insertTable(Table table) {
        if (map.containsKey(table.tableName())){
            throw new IllegalArgumentException("重复的表名");
        }
        map.put(table.tableName(),table);
        return true;
    }

    @Override
    public Table getTable(String tableName) {
        if (!map.containsKey(tableName)){
            throw new IllegalArgumentException("非法的表名");
        }
        return map.get(tableName);
    }

    @Override
    public Iterator<Table> iterator() {
        return this.map.values().iterator();
    }
}
