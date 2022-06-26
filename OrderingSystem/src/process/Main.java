package process;

import database.Init;
import database.TableGetter;
import database.procs.GetAvailablePrimarykey;
import database.record.types.ImmutableRecord;
import exec.Tasks;
import process.welcome.WelcomeTask;
import ui.FormHandler;
import ui.UIOperations.LookOnlyOperations;
import ui.UIOperations.UIOperations;
import ui.displayables.AppointmentUIDisplay;
import ui.displayables.PaymentUIDisplay;
import ui.displayables.TodayAppointmentUIDisplay;
import ui.displayables.UserOrderedMenuUIDisplay;

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

        tasks.offer(new WelcomeTask().getTasks());

        tasks.offer(new FormHandler(new UserOrderedMenuUIDisplay("1"),new UIOperations()));
        tasks.exec();

        tasks.offer(new FormHandler(new PaymentUIDisplay(),new UIOperations()));

        tasks.offer(new FormHandler(new TodayAppointmentUIDisplay(),new UIOperations()));
        tasks.exec();

        tasks.offer(new FormHandler(new AppointmentUIDisplay(),new UIOperations()));
        tasks.exec();
    }
}
