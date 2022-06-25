package process.menu;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.table.types.ImmutableTable;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.AvailableMenuUIDisplay;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 类名:     AvailableMenu
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AvailableMenu implements Menu {
    private volatile static AvailableMenu uniqueInstance;

    private AvailableMenu() {
        targetTable = new TableGetter("Menu").getTable();
        update();
    }

    public static AvailableMenu getInstance() {
        if (uniqueInstance == null) {
            synchronized (AvailableMenu.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new AvailableMenu();
                }
            }
        }
        return uniqueInstance;
    }

    private final LinkedList<ImmutableRecord> records = new LinkedList<>();

    private final ImmutableTable targetTable;

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (ImmutableRecord record : records) {
            totalPrice = totalPrice + Double.parseDouble(
                record.getAttribute("dish_price").getValue()
            );
        }
        return totalPrice;
    }

    @Override
    public FormHandler list() {
        return new FormHandler(new AvailableMenuUIDisplay(this),
            new UIOperations());
    }

    //    AvailableMenu不提供增加方法
    @Override
    public void appendNewMenu(Menu menu) {
    }

    @Override
    public void update() {
        this.records.clear();
        for (ImmutableRecord record : targetTable) {
            int remain = Integer.parseInt(record.getAttribute("remain_quantity").getValue());
            if (remain >= 1) {
                records.offer(record);
            }
        }
    }

    @Override
    public Iterator<ImmutableRecord> iterator() {
        return this.records.iterator();
    }
}
