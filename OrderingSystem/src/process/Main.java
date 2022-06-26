package process;

import database.Init;
import exec.Tasks;
<<<<<<< HEAD
=======
import exec.recall.Recevier;
import process.login.LoginTask;
import process.order.Order;
import process.welcome.WelcomeTask;
>>>>>>> 9b5297da957ed9dc49704b584a9e41512101ba48
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

<<<<<<< HEAD
//        tasks.offer(new LoginTask().getLogin());
//        tasks.exec();

        FormHandler f = new FormHandler(new AvailableMenuUIDisplay(),new UIOperations());
        tasks.offer(f);
=======
    public static void main(String[] args) throws SQLException {
        // 初始化数据库
        tasks.offer(new Init("OrderingSystem"));
        tasks.exec();

        // 欢迎界面
        tasks.offer(new WelcomeTask().getTasks());

>>>>>>> 9b5297da957ed9dc49704b584a9e41512101ba48
        tasks.exec();
    }
}
