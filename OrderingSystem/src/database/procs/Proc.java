package database.procs;

import database.table.types.ImmutableTable;

public interface Proc {
    ImmutableTable exec();
}
