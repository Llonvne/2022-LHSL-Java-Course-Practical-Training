package process.payment;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.ImmutableTable;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.status.UIStatus;

import java.util.Scanner;

/**
 * 类名:     PaymentChooseModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class PaymentChooseModule extends ExecWithSender {
    private final String orderId;

    public PaymentChooseModule(Recevier<Exec> sender, String orderId) {
        super(sender);
        this.orderId = orderId;
    }

    @Override
    public void exec() {
        Exec exec = new FormHandler(new PaymentUIDisplay(), new UIOperations() {
            @Override
            public void userInput() {
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();
                Table table = new TableGetter("支付方式").getTable();
                int size = table.size();
                int ichoice = 0;
                try {
                    ichoice = Integer.parseInt(choice);
                } catch (Exception e) {
                    System.out.println("输入有误请重新输入");
                    getStatusController().setStatus(UIStatus.INIT);
                }
                if (ichoice >= 1 && ichoice <= size) {
                    Table payment = new TableGetter("支付方式").getTable();
                    ImmutableRecord payRecord = payment.getRecordByPrimaryKey(choice);
                    String payMethod = payRecord.getAttribute("支付方式").getValue();

                    System.out.println("支付成功!");

                    Table order = new TableGetter("订单表").getTable();
                    ImmutableRecord record = order.getRecordByPrimaryKey(orderId);
                    MuteableRecord newRecord = order.getEmptyRecord();
                    for (String key : record.getKeys()) {
                        newRecord.updateAttribute(new KeyPair<>(key, record.getAttribute(key).getValue()));
                    }
                    newRecord.updateAttribute(new KeyPair<>("支付状态", "已支付"));
                    newRecord.updateAttribute(new KeyPair<>("客户状态", "离开"));
                    newRecord.updateAttribute(new KeyPair<>("支付方式", payMethod));
                    order.updateRecord(newRecord);
                } else {
                    System.out.println("输入有误请重新输入");
                    getStatusController().setStatus(UIStatus.INIT);
                }
            }
        });
        exec.exec();
    }
}
