package process.login;

import exec.Exec;
import exec.Tasks;
import exec.recall.Recevier;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.UIOperations.UIOperationsWithSender;
import ui.displayables.StandardUIDisplay;

import java.util.Scanner;

/**
 * 类名:     LoginTask
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public final class LoginTask {
    public static Tasks getLoginTask() {
        Tasks loginTask = new Tasks();
        loginTask.offer(getWelcomeTask());
        return loginTask;
    }

    private static Tasks getWelcomeTask() {
        Tasks welcomeTask = new Tasks();

        Recevier<String> userChoice = choice -> System.out.println("用户选择了" + choice);

        Exec welcomeForm = new FormHandler(
            new StandardUIDisplay(
                "欢迎登入点餐系统",
                """
                    1.用餐
                    2.管理员登入
                    3.退出""",
                "请输入"),
            new UIOperationsWithSender<>(userChoice) {
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    this.send(choice);
                }
            }
        );
        welcomeTask.offer(welcomeForm);
        return welcomeTask;
    }
}
