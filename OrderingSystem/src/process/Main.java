package process;

import database.Init;
import exec.Tasks;
import process.welcome.WelcomeTask;
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
public class Main<f> {
    public static Tasks tasks = new Tasks();

//        tasks.offer(new LoginTask().getLogin());
//        tasks.exec();


    public static void main(String[] args) throws SQLException {
        // 初始化数据库
        tasks.offer(new Init("OrderingSystem"));
        tasks.exec();

        // 欢迎界面
        tasks.offer(new WelcomeTask().getTasks());

        FormHandler f = new FormHandler(new AvailableMenuUIDisplay(),new UIOperations());
        tasks.offer(f);

        tasks.exec();
    }
}
