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
import exec.recall.Recevier;
import process.login.LoginTask;
import process.order.Order;
import process.welcome.WelcomeTask;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.AvailableMenuUIDisplay;
import ui.displayables.WelcomeUIDisplay;

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
    public static Tasks tasks = new Tasks();

    public static void main(String[] args) throws SQLException {
        // 初始化数据库
        tasks.offer(new Init("OrderingSystem"));
        tasks.exec();

        // 欢迎界面
        tasks.offer(new WelcomeTask().getTasks());

        tasks.exec();
    }
}
