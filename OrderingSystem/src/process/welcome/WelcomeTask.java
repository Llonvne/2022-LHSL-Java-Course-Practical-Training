package process.welcome;

import exec.Tasks;
import process.Main;
import process.login.LoginTask;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.WelcomeUIDisplay;

import java.util.Scanner;

/**
 * 类名:     WelcomeTask
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class WelcomeTask {
    public Tasks getTasks() {
        Tasks tasks = new Tasks();
        tasks.offer(new FormHandler(
            new WelcomeUIDisplay(),
            new UIOperations() {
                @Override
                public void userInput() {
                    System.out.println("1.客户用餐/查询订单状态");
                    System.out.println("2.管理员登入");
                    System.out.print(">>>");
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
//                        Main.tasks.offer();
                    } else if (choice.equals("2")) {
                        Main.tasks.offer(new LoginTask().getLogin());
                    }
                }
            }
        ));
        return tasks;
    }
}
