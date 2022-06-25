package process.order;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.table.types.ImmutableTable;
import process.menu.Menu;
import process.order.status.OrderStatus;

import java.sql.SQLException;

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
    private ImmutableRecord orderRecord;

    public Order(String order_number) {
        TableGetter tableGetter = new TableGetter("Orders");
        ImmutableTable orders = tableGetter.getTable();
        try {
            orderRecord = orders.getRecordByPrimaryKey(order_number);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("订单号不存在");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMenu(Menu menu){

    }

    private void exec() {
    }
}
