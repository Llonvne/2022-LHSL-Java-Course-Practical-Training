package database.table;
import database.record.ImmutableRecord;
import database.record.MuteableRecord;
import database.record.Record;
import database.record.types.RecordConstructor;

import java.util.Iterator;

public class Table implements TableInterface{
    // TODO 实现数据库操作
    private final RecordConstructor recordConstructor;
    private final ImmutableRecord emptyRecord;

    public Table(RecordConstructor constructor){
        this.recordConstructor = constructor;
        this.emptyRecord = constructor.generatorEmptyRecord();
    }

    public RecordConstructor getConstructor(){
        return recordConstructor;
    }

    @Override
    public boolean insertRecord(Record e) {
//        表结构不一致停止插入
        if (!e.isStructureEqual(this.emptyRecord)){
            return false;
        }
//        如果包含主键为 e 的
        if (contains(e)){
//            如果记录完全一致,停止插入
            if (e.equals(getRecordByPrimaryKey(e.getPrimaryKey()))){
                return true;
            }
//            不然从数据库删除 e
            remove(e);
        }
//        开始向数据库插入 e
        // TODO 将记录插入数据库
        return true;
    }

//    该方法仅检查是否有记录主键为 e 的主键
    @Override
    public boolean contains(ImmutableRecord e) {
        //表结构不一致停止检测
        if (!e.isStructureEqual(this.emptyRecord)){
            return false;
        }
        //TODO 向数据库检测

        return false;
    }

    @Override
    public MuteableRecord getRecordByPrimaryKey(String primaryKey) {
//        从数据库获取 主键为 primaryKey 的记录
        MuteableRecord record = getConstructor().generatorEmptyRecord();
        //TODO 开始向记录写入数据
        return record;
    }

    @Override
    public boolean remove(Record e) {
        if (contains(e)){
            //TODO 向数据库执行删除操作
            return true;
        }
        return false;
    }

    @Override
    public Iterator<ImmutableRecord> iterator() {
        // TODO 从头开始数据库记录
        return new Iterator<ImmutableRecord>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public ImmutableRecord next() {
                return null;
            }
        };
    }
}
