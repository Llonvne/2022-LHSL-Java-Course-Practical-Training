package process.order;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.sqlTools.CopyRecord;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import process.menu.AvailableMenuUIDisplay;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.status.UIStatus;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 类名:     OrderingModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class OrderingModule extends ExecWithSender {
    private final String orderId;

    public OrderingModule(Recevier<Exec> sender, String orderId) {
        super(sender);
        this.orderId = orderId;
    }

    @Override
    public void exec() {
        new FormHandler(new AvailableMenuUIDisplay(), new UIOperations() {
            private final Table availableMenu = new TableGetter("可用菜品表").getTable();
            private final int availableMenuSize = availableMenu.size();
            private final LinkedList<ImmutableRecord> records = new LinkedList<>();

            private final Table table = new TableGetter("已点餐表").getTable();

            int primaryKey = new GetAvailablePrimarykey(table.tableName(), table.getEmptyRecord().getPrimaryKey()).exec();

            @Override
            public void userInput() {
                MuteableRecord r = table.getEmptyRecord();
                System.out.println("请输入想吃的菜品编号:(以 0 结束)");
                System.out.println(">>>");
                int choice;
                int size;
                String note;
                try {
                    Scanner scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                    if (choice == 0) {
                        getStatusController().setStatus(UIStatus.HANDLER_USER_INPUT);
                        return;
                    }
                    if (choice > availableMenuSize || choice < 0) {
                        throw new IllegalArgumentException("菜品号不合法");
                    }
                    System.out.println("请输入想吃的菜品份数:");
                    System.out.println(">>>");
                    size = scanner.nextInt();
                    if (size <= 0) {
                        throw new IllegalArgumentException("菜品数量不合法");
                    }
                    note = scanner.next();
                } catch (Exception e) {
                    System.out.println("输入有误，请重新输入！");
                    getStatusController().setStatus(UIStatus.DISPLAY);
                    return;
                }

                r.updateAttribute(new KeyPair<>(r.getPrimaryKey(), String.valueOf(primaryKey++)));
                r.updateAttribute(new KeyPair<>("菜品编号", String.valueOf(choice)));
                r.updateAttribute(new KeyPair<>("份数", String.valueOf(size)));
                r.updateAttribute(new KeyPair<>("备注", String.valueOf(note)));
                r.updateAttribute(new KeyPair<>("订单号", orderId));

                this.records.add(r);

                ImmutableRecord meal = new TableGetter("菜品表").getTable()
                    .getRecordByPrimaryKey(String.valueOf(choice));
                System.out.println("你已成功将 " + meal.getAttribute("菜品名").getValue() + " " + size + " 份添加到菜单 备注为:" + note);

                this.getStatusController().setStatus(UIStatus.DISPLAY);
            }

            public void recall() {

                System.out.println("请确认你的菜单");
                System.out.println("------------------- 订单 -------------------");
                System.out.println("菜品名      份数      备注");
                for (ImmutableRecord record : this.records) {
                    ImmutableRecord meal = new TableGetter("菜品表").getTable()
                        .getRecordByPrimaryKey(String.valueOf(record.getAttribute("菜品编号").getValue()));
                    System.out.println(meal.getAttribute("菜品名").getValue() + "\t\t" +
                        record.getAttribute("份数").getValue() + "\t\t" + record.getAttribute("备注").getValue());
                }
                System.out.println("");
                System.out.println("------------------- 订单 -------------------");
                System.out.println("请输入 1 确认，任意键取消");

                Scanner scanner = new Scanner(System.in);
                try {
                    if (scanner.nextInt() != 1) {
                        throw new IllegalArgumentException("取消订单");
                    }
                } catch (Exception e) {
                    return;
                }

                Table menu = new TableGetter("菜品表").getTable();

                for (ImmutableRecord r : records) {
                    table.insertRecord(r);

                    // 更新数量
                    ImmutableRecord meal = menu.getRecordByPrimaryKey(r.getAttribute("菜品编号").getValue());
                    MuteableRecord newMeal = menu.getEmptyRecord();
                    CopyRecord.record(meal, newMeal);
                    newMeal.updateAttribute(new KeyPair<>("剩余数量",
                        String.valueOf(
                            Integer.parseInt(meal.getAttribute("剩余数量").getValue()) -
                                Integer.parseInt(r.getAttribute("份数").getValue())
                        )));
                    menu.updateRecord(newMeal);
                }
                System.out.println("您已成功下单");

                Table orderTable = new TableGetter("订单表").getTable();
                ImmutableRecord record = orderTable.getRecordByPrimaryKey(orderId);
                MuteableRecord newrecord = orderTable.getEmptyRecord();
                for (String key : record.getKeys()) {
                    newrecord.updateAttribute(new KeyPair<>(key, record.getAttribute(key).getValue()));
                }
                newrecord.updateAttribute(new KeyPair<>("客户状态", "就餐"));
                newrecord.updateAttribute(new KeyPair<>("支付状态", "未支付"));
                orderTable.updateRecord(newrecord);
            }
        }).exec();
    }
}
