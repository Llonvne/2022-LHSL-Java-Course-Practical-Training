package database.commonSQLTasks;

import database.StandardUnifiedDatabaseOperations;
import database.UnifiedDatabaseOperations;
import database.table.TableFactory;
import database.table.generator.StandardTableGenerator;
import database.table.pool.generator.StandardTablePoolGenerator;

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
}
