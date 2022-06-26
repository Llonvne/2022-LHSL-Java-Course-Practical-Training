package database.procs;

import database.DatabaseHandler;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;

/**
 * 类名:     UserLogin
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class UserLogin implements Proc {
    private final String username;
    private final String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ImmutableTable exec() {
        return DatabaseHandler.getInstance().getDatabaseHandler().getResultSetTable(
            "登入表",
            QueryExecute.executeQuery("CALL 用户登入('" + username + "','" + password + "');")
        );
    }

}
