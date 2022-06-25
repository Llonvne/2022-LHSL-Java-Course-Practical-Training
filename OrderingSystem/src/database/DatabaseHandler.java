package database;

import database.record.types.MuteableRecord;
import database.table.types.Table;
import database.unifiedDatabaseOperations.StandardUnifiedDatabaseOperations;
import database.unifiedDatabaseOperations.UnifiedDatabaseOperations;
import database.table.TableFactory;
import database.table.generator.StandardTableGenerator;
import database.table.pool.generator.StandardTablePoolGenerator;
import exec.recall.DataWithRecallSender;
import exec.recall.Recevier;

public class DatabaseHandler {
    private volatile static DatabaseHandler uniqueInstance;
    private static UnifiedDatabaseOperations unifiedDatabaseOperations;

    private DatabaseHandler() {
    }

    public static DatabaseHandler getInstance() {
        if (uniqueInstance == null) {
            synchronized (DatabaseHandler.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DatabaseHandler();

                    TableFactory tableFactory = new TableFactory(new StandardTableGenerator(), new StandardTablePoolGenerator());
                    unifiedDatabaseOperations = new StandardUnifiedDatabaseOperations(tableFactory);
                }
            }
        }
        return uniqueInstance;
    }

    public UnifiedDatabaseOperations getDatabaseHandler() {
        return unifiedDatabaseOperations;
    }

    public Recevier<DataWithRecallSender<String, Table>> getDatabaseReceiver() {
        return receiver -> {
            Table target = getInstance().getDatabaseHandler().getTable(receiver.getData());
            receiver.send(target);
        };
    }
}
