import exec.Exec;
import exec.Tasks;
import exec.recall.DataWithRecallSender;
import exec.recall.Recevier;
import exec.recall.Sender;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.UIOperations.UIOperationsWithSender;
import ui.displayables.NotificationUIDisplay;
import ui.status.UIStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 类名:     TestUI
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/21
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TestUI {
    public static void main(String[] args) {
        Tasks loginTask = new Tasks();
        Exec WelcomeForm = new FormHandler(
            new NotificationUIDisplay(
                "欢迎登入点餐系统", "输入1开始登入\n"
            ),
            new UIOperations() {
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();
                    if (choice != 1) {
                        getStatusController().setStatus(UIStatus.INIT);
                    }
                }
            }
        );
        Recevier<Map<String, String>> receiver = usernameAndPassword -> {
            System.out.println(usernameAndPassword.get("username"));
            System.out.println(usernameAndPassword.get("password"));
        };
        Exec loginForm = new FormHandler(
            new NotificationUIDisplay("欢迎登入点餐系统", "请输入账号密码"),
            new UIOperations() {
                private Sender<Map<String, String>> sender;
                private final Map<String, String> usernameAndPassword = new HashMap<>();

                @Override
                public void init() {
                    sender = new Sender<>();
                    sender.bindRecevier(receiver);
                }

                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String userName = scanner.nextLine();
                    String password = scanner.nextLine();
                    usernameAndPassword.put("password", password);
                    usernameAndPassword.put("username", userName);
                }

                @Override
                public void recall() {
                    sender.send(usernameAndPassword);
                }
            }
        );
        loginTask.offer(WelcomeForm);
        loginTask.offer(loginForm);

        Recevier<String> nameReceiver = s -> System.out.println("名字是" + s);
        Exec nameInput = new FormHandler(
            new NotificationUIDisplay(
                "请输入名字", ">>>"),
            new UIOperationsWithSender<>(nameReceiver) {
                String name;

                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    name = scanner.nextLine();
                }

                @Override
                public void recall() {
                    send(name);
                }
            }
        );
        nameInput.exec();

        Recevier<DataWithRecallSender<String, Boolean>> passwordReceiver = data -> {
            data.send(data.getData().equals("12345"));
        };
        Exec passwordExec = new FormHandler(
            new NotificationUIDisplay("请输入密码",">>>"),
            new UIOperationsWithSender<>(passwordReceiver) {
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String password = scanner.nextLine();
                    Recevier<Boolean> isValid = vaild -> {
                        if (vaild) {
                            System.out.println("密码正确");
                        }
                        else {
                            System.out.println("密码错误");
                        }
                    };
                    send(new DataWithRecallSender<>(password,isValid));
                }
            }
        );

        Recevier<DataWithRecallSender<String,String>> usernameReceiver = dataWithRecevier -> {
            if (dataWithRecevier.getData().equals("Llonvne")){
                dataWithRecevier.send("账号正确!!!!!!");
            }
            else {
                dataWithRecevier.send("账号有误！");
            }
        };

        Exec exec1 = new FormHandler(
            new NotificationUIDisplay("请输入用户名",">>>"),
            new UIOperationsWithSender<>(usernameReceiver){
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String username = scanner.nextLine();

                    Recevier<String> result = System.out::println;

                    this.send(new DataWithRecallSender<>(username,result));
                }
            }
        );
        exec1.exec();
    }
}
