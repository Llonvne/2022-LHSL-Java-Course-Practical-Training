package process.account.admin;

import database.keyValue.KeyPair;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.DataWithRecallSender;
import exec.recall.Recevier;
import process.account.Account;
import process.account.AccountInfo;
import ui.FormHandler;
import ui.UIOperations.UIOperations;

/**
 * 类名:     AdminModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AdminModule extends ExecWithSender implements Account {
    private final String account;

    public AdminModule(Recevier<Exec> sender, String account) {
        super(sender);
        this.account = account;
    }

    public static final String accountType = "管理员";

    public static Recevier<AccountInfo> getRecevier() {
        return accountInfo -> {
            // 如果类型相同
            if (accountInfo.type().equals(accountType)) {
                accountInfo.sender().toRecevier(new AdminModule(
                    accountInfo.sender(), accountInfo.account()
                ));
            }
        };
    }

    @Override
    public void exec() {
        send(new FormHandler(new AdminUIDisplay(account), new UIOperations()));
    }
}
