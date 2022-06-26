package database.procs;

import database.table.types.ImmutableTable;

public interface ResultProc {
    ImmutableTable exec();
}
