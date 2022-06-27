package process.account.admin;

import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import process.account.Account;
import process.account.AccountInfo;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.status.UIStatus;

import java.util.Scanner;

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

                // 建立 account
                Account account = new AdminModule(accountInfo.sender(), accountInfo.account());

                // 执行 account
                accountInfo.sender().toRecevier(account);
            }
        };
    }

    @Override
    public void exec() {
        new FormHandler(new AdminUIDisplay(account), new UIOperations() {
            @Override
            public void userInput() {
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();
                int ichoice = 0;
                try {
                    ichoice = Integer.parseInt(choice);
                } catch (Exception e) {
                    System.out.println("选择有误，请重新输入");
                    getStatusController().setStatus(UIStatus.DISPLAY);
                }
                if (ichoice >= 1 && ichoice <= 7) {
                    // TODO 操作
                }

            }
        }).exec();
    }
}
