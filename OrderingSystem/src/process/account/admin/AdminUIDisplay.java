package process.account.admin;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.table.types.ImmutableTable;
import ui.Displayable;

/**
 * 类名:     AdminUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AdminUIDisplay implements Displayable {
    private final String account;
    private String identifier;

    public AdminUIDisplay(String account) {
        this.account = account;
    }

    @Override
    public void display() {
        ImmutableTable accounts = new TableGetter("员工表").getTable();
        ImmutableRecord record = accounts.getRecordByPrimaryKey(account);
        this.identifier = record.getAttribute("员工身份").getValue();

        System.out.println("欢迎您 " + account + " " + identifier + " >>>");
        System.out.println("1. 菜单修改");
        System.out.println("2. 员工修改");
        System.out.println("3. 支付方式修改");
        System.out.println("4. 桌型修改");
        System.out.println("5. 预约修改");
        System.out.println("6. 订单修改");
        System.out.println("7. 等待修改");
    }
}
