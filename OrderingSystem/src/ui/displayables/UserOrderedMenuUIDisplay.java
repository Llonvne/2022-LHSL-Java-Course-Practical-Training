package ui.displayables;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import ui.Displayable;


/**
 * 类名:     UserOrderedMenuUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class UserOrderedMenuUIDisplay implements Displayable {
    public String orderId;

    public UserOrderedMenuUIDisplay(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void display() {
        System.out.println("------------------------------ 订单 ------------------------------");
        System.out.println("订单号    客户状态    预约号    桌号    支付方式    支付状态    手机号    等待号");
        for (ImmutableRecord record : new TableGetter("可用菜品表").getTable()) {
            System.out.println(record.getAttribute("订单号").getValue() +
                    record.getAttribute("客户状态").getValue() +
                    record.getAttribute("预约号").getValue() +
                    record.getAttribute("桌号").getValue() +
                    record.getAttribute("支付方式").getValue() +
                    record.getAttribute("支付状态").getValue() +
                    record.getAttribute("手机号").getValue() +
                    record.getAttribute("等待号").getValue());
        }
    }
}
