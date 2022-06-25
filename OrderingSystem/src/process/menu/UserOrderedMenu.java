package process.menu;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.record.types.Record;
import database.table.types.Table;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.UserOrderedMenuUIDisplay;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 类名:     UserOrderedMenu
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class UserOrderedMenu implements Menu {
    private final LinkedList<ImmutableRecord> menu = new LinkedList<>();
    private final Table targetTable;

    private final String order_number;

    public UserOrderedMenu(String order_number) {
        this.order_number = order_number;
        TableGetter tableGetter = new TableGetter("Ordered_menus");
        targetTable = tableGetter.getTable();
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (ImmutableRecord record : targetTable) {
            total += PriceGetter.getPrice(record);
        }
        return total;
    }

    @Override
    public FormHandler list() {
        return new FormHandler(new UserOrderedMenuUIDisplay(),
            new UIOperations());
    }

    @Override
    public void appendNewMenu(Menu menu) {

    }

    @Override
    public void update() {
        this.menu.clear();
        for (ImmutableRecord record : targetTable) {
            if (record.getAttribute("order_number").equals(this.))
        }
    }

    @Override
    public Iterator<ImmutableRecord> iterator() {
        return this.menu.iterator();
    }
}
