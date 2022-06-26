package process;

import database.DatabaseHandler;
import database.Init;
import database.procs.GetUserOrderedMenu;
import database.procs.UserLogin;
import database.record.types.ImmutableRecord;
import database.sqlTools.AdvanceResultSet;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;
import exec.Tasks;
import process.login.LoginTask;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.AvailableMenuUIDisplay;

import java.sql.SQLException;

/**
 * 类名:     process.Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Tasks tasks = new Tasks();
        tasks.offer(new Init("OrderingSystem"));

        tasks.offer(new LoginTask().getLogin());
        tasks.exec();

        FormHandler f = new FormHandler(new AvailableMenuUIDisplay(),new UIOperations());
        f.exec();
    }
}
