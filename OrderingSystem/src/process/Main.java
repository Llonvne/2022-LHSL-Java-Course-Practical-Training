package process;

import database.Init;
import database.TableGetter;
import database.procs.ChangeAppointmentStatus;
import database.procs.GetUserAppointment;
import database.procs.GetUserOrderedMenu;
import database.record.types.ImmutableRecord;
import exec.Tasks;
import process.welcome.WelcomeTask;

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

        for (ImmutableRecord record : new TableGetter("预约表").getTable()) {
            System.out.println(record);
        }
        System.out.println("预约视图");
        for (ImmutableRecord record : new TableGetter("预约状态表").getTable()) {
            System.out.println(record);
        }

        for (ImmutableRecord record : new GetUserOrderedMenu("1").exec()){
            System.out.println(record);
        }
    }
}
