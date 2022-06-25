package process.order;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.record.types.Record;
import database.table.types.ImmutableTable;
import exec.recall.DataWithRecallSender;
import exec.recall.Recevier;
import exec.recall.Sender;
import process.order.operations.*;
import process.order.status.OrderStatus;

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
    private OrderStatus orderStatus;

    private String orderNo;

    private Record orderRecord;

    public Order(String order_number) {
        TableGetter tableGetter = new TableGetter("Orders");
        ImmutableTable orders = tableGetter.getTable();
        ImmutableRecord orderRecord;
        try {
            orderRecord = orders.getRecordByPrimaryKey("order_number");
        }
        catch (IllegalArgumentException e){

        }
    }

    private void exec() {
    }
}
