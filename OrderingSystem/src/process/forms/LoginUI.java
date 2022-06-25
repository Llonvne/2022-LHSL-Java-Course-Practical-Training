package process.forms;

import exec.Exec;
import exec.recall.DataWithRecallSender;
import exec.recall.DataWithRecallableRecevier;
import exec.recall.Recevier;
import ui.FormHandler;
import ui.UIOperations.UIOperationsWithSender;
import ui.displayables.LoginUIDisplay;
import ui.displayables.StandardUIDisplay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 类名:     LoginUI
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class LoginUI {
    public static Exec getUI(){
        Recevier<DataWithRecallSender<Map<String,String>,Boolean>> recevier
            = data -> {
                if (data.getData().get("username").equals("Llonvne") &&
                data.getData().get("password").equals("12345")){
                    data.send(true);
                    return;
                }
                data.send(false);
            };

        return new FormHandler(
            new LoginUIDisplay(),
            new UIOperationsWithSender<>(recevier){
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    Map<String,String> userInfo = new HashMap<>();
                    userInfo.put("username",username);
                    userInfo.put("password",password);
                    Recevier<Boolean> result = result1 -> {
                        if (result1){
                            System.out.println("登入成功");
                        }
                        else {
                            System.out.println("登入失败");
                        }
                    };
                    send(new DataWithRecallSender<>(
                        userInfo,result
                    ));
                }
            }
        );
    }
}
