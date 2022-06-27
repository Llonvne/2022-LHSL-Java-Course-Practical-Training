package process.payment;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import ui.Displayable;

/**
 * 类名:     PaymentUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class PaymentUIDisplay implements Displayable {
    @Override
    public void display() {
        System.out.println(">>>请选择你的支付方式");
        for (ImmutableRecord record : new TableGetter("支付方式").getTable()){
            System.out.println(record.getAttribute("支付方式") + "\t"
            + record.getAttribute("备注").getValue() + "\t");
        }
        System.out.print(">>>");
    }
}
