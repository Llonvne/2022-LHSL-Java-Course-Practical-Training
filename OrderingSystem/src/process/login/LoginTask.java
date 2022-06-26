package process.login;

import database.procs.UserLogin;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;
import exec.Tasks;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.LoginUIDisplay;

import java.util.Scanner;

/**
 * 类名:     LoginTask
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class LoginTask {
    public Tasks getLogin(){
        Tasks tasks = new Tasks();
        FormHandler form = new FormHandler(new LoginUIDisplay(),
            new UIOperations(){
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入账号： ");
                    System.out.print(">>>");
                    String username = scanner.nextLine();
                    System.out.println("请输入密码： ");
                    System.out.print(">>>");
                    String password = scanner.nextLine();

                    if (login(username,password)){
                        System.out.println("登入成功");
                    }
                    else {
                        System.out.println("登入失败");
                    }
                }
            });
        tasks.offer(form);
        return tasks;
    }

    private boolean login(String username, String password) {
        ImmutableTable table = new UserLogin("username","password").exec();
        return table.size() >= 1;
    }
}
