package database.procs;

import database.DatabaseHandler;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;

/**
 * 类名:     getUserOrderedMenu
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetUserOrderedMenu implements Proc<ImmutableTable> {
    private final String orderNo;

    public GetUserOrderedMenu(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public ImmutableTable exec() {
        return DatabaseHandler.getInstance().getDatabaseHandler().getResultSetTable(
            "用户下单表"
            , QueryExecute.executeQuery("CALL 用户下单菜品('" + orderNo + "')")
        );
    }
}
