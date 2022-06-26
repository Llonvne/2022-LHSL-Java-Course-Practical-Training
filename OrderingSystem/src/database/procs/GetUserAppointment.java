package database.procs;

import database.DatabaseHandler;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;

/**
 * 类名:     GetUserAppointment
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetUserAppointment implements ResultProc {
    private String orderId;

    public GetUserAppointment(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public ImmutableTable exec() {
        return DatabaseHandler
            .getInstance()
            .getDatabaseHandler()
            .getResultSetTable("用户预约表",
                QueryExecute.executeQuery("CALL 用户预约状态('" + orderId + "');")
            );
    }
}
