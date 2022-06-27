package process.welcome;

import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import process.account.admin.AdminModule;
import process.login.LoginModule;
import process.order.OrderModule;
import ui.FormHandler;
import ui.UIOperations.UIOperations;

import java.util.Scanner;

/**
 * 类名:     WelcomeTask
 * 描述:     该类是欢迎界面
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class WelcomeTask extends ExecWithSender {

    // 接受任务调度器
    public WelcomeTask(Recevier<Exec> sender) {
        super(sender);
    }

    @Override
    public void exec() {

        // 初始化窗口
        Exec exec = new FormHandler(

            // 传入欢迎 UI Displayable
            new WelcomeUIDisplay(),

            // 为 Welcome Form 定义 Operations
            new UIOperations() {

                // 重写 userInput 方法
                public void userInput() {

                    // 打印提示信息
                    System.out.println("1.客户用餐/查询订单状态");
                    System.out.println("2.管理员登入");
                    System.out.print(">>>");

                    // 处理输入
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();

                    // 使用传入的调度器调度任务
                    if (choice.equals("1")) {

                        // 像任务调度器传入 OrderModule ，并传递任务调度器
                        send(new OrderModule(getSender()));
                    } else if (choice.equals("2")) {

                        LoginModule loginModule = new LoginModule(getSender());
                        loginModule.AddAccountListener(AdminModule.getRecevier());
                        // 像任务调度器传入 LoginModule ，并传递任务调度器
                        send(loginModule);
                    }
                }
            }
        );
        exec.exec();
    }
}

