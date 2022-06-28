package process.account.customer;

import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import process.account.Account;
import process.account.AccountInfo;
import process.account.admin.AdminModule;
import ui.Displayable;
import ui.FormHandler;
import ui.UIOperations.UIOperations;

/**
 * 类名:     Customer
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/28
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class CustomerModule extends ExecWithSender implements Account {
    private String orderId;

    public static final String accountType = "管理员";

    public static Recevier<AccountInfo> getRecevier() {
        return accountInfo -> {
            // 如果类型相同
            if (accountInfo.type().equals(accountType)) {

                // 建立 account
                Account account = new CustomerModule(accountInfo.sender(), accountInfo.account());

                // 执行 account
                accountInfo.sender().toRecevier(account);
            }
        };
    }

    public CustomerModule(Recevier<Exec> sender, String orderId) {
        super(sender);
        this.orderId = orderId;
    }

    @Override
    public void exec() {
        send(new FormHandler(new Displayable() {
            @Override
            public void display() {

            }
        },new UIOperations()));
    }
}
