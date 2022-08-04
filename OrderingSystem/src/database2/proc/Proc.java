package database2.proc;

import database2.exception.DatabaseExecption;

public interface Proc<E> {
    E run() throws DatabaseExecption;
}
