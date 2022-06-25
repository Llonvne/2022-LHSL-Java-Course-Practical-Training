package process.menu;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.table.types.Table;

/**
 * 类名:     PriceGetter
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class PriceGetter {
    public static double getPrice(ImmutableRecord record) {
        Table table = new TableGetter("Menu").getTable();
        for (ImmutableRecord r : table) {
            if (r.getAttribute("dish_number").getValue().equals(
                record.getAttribute("dish_number").getValue()
            )) {
                return Double.parseDouble(r.getAttribute("dish_price").getValue());
            }
        }
        throw new IllegalArgumentException("不存在的菜品号");
    }
}
