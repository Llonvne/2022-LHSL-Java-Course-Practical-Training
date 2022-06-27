package ui.UIOperations;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.Table;

public class PaymentUIPerations extends UIOperations {
    public String wx, zfb, cash, cloud;

//    public PaymentUIPerations(String wx) {this.wx = wx;}
//    public PaymentUIPerations(String zfb) {this.zfb = zfb;}
//    public PaymentUIPerations(String cash) {this.cash = cash;}
//    public PaymentUIPerations(String cloud) {this.cloud = cloud;}

    @Override
    public void userInput() {

        Table menu = new TableGetter("支付方式").getTable();
        MuteableRecord record = menu.getEmptyRecord();
        record.updateAttribute(new KeyPair<>(record.getPrimaryKey(), String.valueOf(GetAvailablePrimarykey.getAvailablePrimarykey(menu.tableName(), record.getPrimaryKey()))));
        menu.insertRecord(record);
        ImmutableRecord r1 = menu.getRecordByPrimaryKey("微信支付");
        MuteableRecord r2 = menu.getEmptyRecord();
        for (String key : r1.getKeys()) {
            r2.updateAttribute(new KeyPair<>(key, r1.getAttribute(key).toString()));
        }
        menu.updateRecord(r2);
        for (ImmutableRecord r : menu) {
            System.out.println(r);
        }
    }
}

