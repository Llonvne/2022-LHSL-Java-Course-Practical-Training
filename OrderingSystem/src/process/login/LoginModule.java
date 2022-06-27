package process.login;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.UserLogin;
import database.record.types.ImmutableRecord;
import database.table.types.ImmutableTable;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import exec.recall.Sender;
import process.account.Account;
import process.account.AccountInfo;
import ui.FormHandler;
import ui.UIOperations.UIOperations;

import java.util.Scanner;

/**
 * 类名:     LoginTask
 * 描述:     登入处理类
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class LoginModule extends ExecWithSender {

    // 构造 LoginModule 接受任务调度器
    public LoginModule(Recevier<Exec> sender) {
        super(sender);
    }

    public void AddAccountListener(Recevier<AccountInfo> recevier) {
        accountSender.bindRecevier(recevier);
    }

    private final Sender<AccountInfo> accountSender = new Sender<>();

    // 处理登入事件
    private boolean login(String username, String password) {
        ImmutableTable table = new UserLogin(username, password).exec();
        return table.size() >= 1;
    }

    private String account;

    @Override
    public void exec() {
        FormHandler form = new FormHandler(new LoginUIDisplay(),
            new UIOperations() {
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入账号： ");
                    System.out.print(">>>");
                    account = scanner.nextLine();
                    System.out.println("请输入密码： ");
                    System.out.print(">>>");
                    String password = scanner.nextLine();

                    if (login(account, password)) {
                        System.out.println("登入成功");
                    } else {
                        System.out.println("登入失败");
                    }
                }
            });
        form.exec();

        ImmutableTable accounts = new TableGetter("员工表").getTable();
        ImmutableRecord record = accounts.getRecordByPrimaryKey(account);
        String identifier = record.getAttribute("员工身份").getValue();

        accountSender.send(new AccountInfo(account, identifier, getSender()));
    }
}
