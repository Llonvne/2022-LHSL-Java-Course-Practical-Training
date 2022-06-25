package database.table.types;

import database.sqlTools.AdvanceResultSet;
import database.keyValue.KeyPair;
import database.sqlTools.QueryExecuter;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.record.constructor.recordConstructor.RecordConstructor;

import java.sql.SQLException;
import java.util.Iterator;

public class StandardTable implements Table {
    // TODO 实现数据库操作
    private final RecordConstructor recordConstructor;
    private final ImmutableRecord emptyRecord;
    private final String name;

    public StandardTable(String name, RecordConstructor constructor) {
        this.name = name;
        this.recordConstructor = constructor;
        MuteableRecord record = constructor.generatorEmptyRecord();
        record.setTableName(tableName());
        this.emptyRecord = record;
    }

    private RecordConstructor getConstructor() {
        return recordConstructor;
    }

    @Override
    public boolean insertRecord(ImmutableRecord e) throws SQLException {
//        表结构不一致停止插入
        if (!e.isStructureEqual(this.emptyRecord)) {
            throw new IllegalArgumentException("表结构不一致");
        }
//        如果包含主键为 e 的
        if (contains(e)) {
//            如果记录完全一致,停止插入
            if (e.equals(getRecordByPrimaryKey(e.getAttribute(e.getPrimaryKey()).getValue()))) {
                return true;
            }

            throw new IllegalArgumentException("主键冲突");
        }

        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName() + " (");
        for (String key : e.getKeys()) {
            sql.append(key).append(",");
        }
        sql.delete(sql.length() - 1, sql.length());
        sql.append(") VALUES (");
        for (String key : e.getKeys()) {
            sql.append("'");
            sql.append(e.getAttribute(key).getValue());
            sql.append("'").append(",");
        }
        sql.delete(sql.length() - 1, sql.length());
        sql.append(");");
        QueryExecuter.execute(sql.toString());
        // TODO 将记录插入数据库
        return true;
    }

    //    该方法仅检查是否有记录主键为 e 的主键
    @Override
    public boolean contains(ImmutableRecord e) throws SQLException {
        //表结构不一致停止检测
        if (!e.isStructureEqual(this.emptyRecord)) {
            throw new IllegalArgumentException("表结构不一致");
        }
        //TODO 向数据库检测
        String sql = "select " + "count(*) as answer " + "from " + tableName() +
            " where " + emptyRecord.getPrimaryKey() + " = " + e.getAttribute(e.getPrimaryKey()).getValue();
        AdvanceResultSet resultSet = QueryExecuter.executeQuery(sql);
        resultSet.getResultSet().next();
        boolean r = resultSet.getResultSet().getInt("answer") == 1;
        resultSet.closeAll();
        return r;
    }

    @Override
    public MuteableRecord getRecordByPrimaryKey(String primaryKey) throws SQLException {
//        从数据库获取 主键为 primaryKey 的记录
        String sql = "select * from " + tableName()
            + " where " + emptyRecord.getPrimaryKey() + " = " + primaryKey;
        AdvanceResultSet resultSet = QueryExecuter.executeQuery(sql);
        MuteableRecord record = getEmptyRecord();
        resultSet.getResultSet().next();
        for (String key : emptyRecord.getKeys()) {
            record.updateAttribute(new KeyPair<>(key, resultSet.getResultSet().getString(key)));
        }
        resultSet.closeAll();
        return record;
    }

    @Override
    public String tableName() {
        return name;
    }

    @Override
    public boolean remove(ImmutableRecord e) throws SQLException {
        if (contains(e)) {
            //TODO 向数据库执行删除操作
            String sql = "DELETE FROM " + tableName() + " where " + emptyRecord.getPrimaryKey() +
                " = " + e.getAttribute(e.getPrimaryKey()).getValue();

            QueryExecuter.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public MuteableRecord getEmptyRecord() {
        MuteableRecord record = getConstructor().generatorEmptyRecord();
        record.setTableName(this.tableName());
        return record;
    }

    @Override
    public boolean updateRecord(ImmutableRecord e) throws SQLException {
        if (!e.isStructureEqual(this.emptyRecord)) {
            throw new IllegalArgumentException("表结构不一致");
        }
        ImmutableRecord target = getRecordByPrimaryKey(e.getAttribute(e.getPrimaryKey()).getValue());
        if (e.equals(target)) {
            return true;
        }

        StringBuilder sql = new StringBuilder("UPDATE " + tableName() + " SET ");
        for (String key : e.getKeys()) {
            if (key.equals(e.getPrimaryKey())){
                continue;
            }
            sql.append(key).append(" = ").append("'").append(e.getAttribute(key).getValue()).append("', ");
        }
        sql.delete(sql.length()- 2,sql.length());
        sql.append(" where " + e.getPrimaryKey() + " = " + e.getAttribute(e.getPrimaryKey()).getValue());

        QueryExecuter.execute(sql.toString());

        // TODO 更新
        return true;
    }

    @Override
    public Iterator<ImmutableRecord> iterator() {
        // TODO 从头开始数据库记录
        return new Iterator<>() {
            private final String sql = "select * from " + tableName();
            private final AdvanceResultSet resultSet;

            {
                try {
                    resultSet = QueryExecuter.executeQuery(sql);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public boolean hasNext() {
                boolean result;
                try {
                     result = resultSet.getResultSet().next();
                    if (!result) {
                        resultSet.closeAll();
                    }
                    return result;
                } catch (Exception e) {
                    throw new RuntimeException("数据库异常");
                }
            }

            @Override
            public ImmutableRecord next() {
                MuteableRecord record = getEmptyRecord();
                for (String key : emptyRecord.getKeys()) {
                    try {
                        record.updateAttribute(new KeyPair<>(key, resultSet.getResultSet().getString(key)));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                return record;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String key : emptyRecord.getKeys()){
            res.append(key).append(" ");
        }
        res.append("\n");
        for (ImmutableRecord record : this){
            for (String key : record.getKeys()){
                res.append(record.getAttribute(key).getValue()).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
