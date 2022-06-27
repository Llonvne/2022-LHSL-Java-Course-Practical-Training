package ui.UIOperations;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.Table;
import java.util.Scanner;

public class PaymentUIPerations extends UIOperations {
    public String wx, zfb, cash, cloud;
    public int choice;

//    public PaymentUIPerations(String wx) {this.wx = wx;}
//    public PaymentUIPerations(String zfb) {this.zfb = zfb;}
//    public PaymentUIPerations(String cash) {this.cash = cash;}
//    public PaymentUIPerations(String cloud) {this.cloud = cloud;}

    @Override
    public void userInput() {
        Table menu = new TableGetter("支付方式").getTable();
        //增加记录
        MuteableRecord record = menu.getEmptyRecord();
        record.updateAttribute(new KeyPair<>(record.getPrimaryKey(), String.valueOf(new GetAvailablePrimarykey(menu.tableName(), record.getPrimaryKey()).exec())));
        menu.insertRecord(record);
        ImmutableRecord r1 = menu.getRecordByPrimaryKey("花呗支付");
        r1.getAttribute("支付方式");
        MuteableRecord r2 = menu.getEmptyRecord();
        for (String key : r1.getKeys()) {
            r2.updateAttribute(new KeyPair<>(key, r1.getAttribute("支付方式").getValue()));
        }
        r2.updateAttribute(new KeyPair<>("id","5"));
        menu.updateRecord(r2);
        //删除记录


        for (ImmutableRecord r : menu) {
            System.out.println(r);
        }
    }
}

