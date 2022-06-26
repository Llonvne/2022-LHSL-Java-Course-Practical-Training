package process.order;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import exec.Exec;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.UserOrderedMenuUIDisplay;

/**
 * 类名:     Order
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Order {
    private final ImmutableRecord record;
    private final String orderId;

    public Order(String orderId) {
        record = new TableGetter("订单表").getTable().getRecordByPrimaryKey(orderId);
        this.orderId = orderId;
    }


}
