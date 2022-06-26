package ui.UIOperations;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.Table;

import java.util.Scanner;

/**
 * 类名：    MenuUIOPerations
 * 描述：    该类实现对菜单的增删改查
 * 隶属于：
 * 建立事件：   2022/6/26
 * 作者：
 * 邮箱：
 */
public class MenuUIOperations extends UIOperations{
    //价格，其他，数量，菜品名，菜品描述
    private double money;
    private String other;
    private double account;
    private String name;
    private String details;

//   public MenuUIOperations(double money){this.money = money; }
//    public MenuUIOperations(String other){this.other = other; }
//    public MenuUIOperations(double account){this.account = account; }
//    public MenuUIOperations(String name){this.name = name; }
//    public MenuUIOperations(String details){this.details =  details; }

    @Override
    public void userInput() {


        //增加记录
        Scanner scanner = new Scanner(System.in);
        money = scanner.nextDouble();
        other = scanner.next();
        account = scanner.nextDouble();
        name = scanner.next();
        details = scanner.next();

        Table menu = new TableGetter("菜品表").getTable();
        MuteableRecord record = menu.getEmptyRecord();
        record.updateAttribute(new KeyPair<>(record.getPrimaryKey(),String.valueOf(GetAvailablePrimarykey.getAvailablePrimarykey(menu.tableName(),record.getPrimaryKey()))));
        menu.insertRecord(record);

        for (ImmutableRecord r1 : menu){
            System.out.println(r1);
        }

        MuteableRecord r1 = menu.getEmptyRecord();
        menu.updateRecord(r1);

        //修改记录
        for (String key : r1.getKeys()){
            r1.updateAttribute(new KeyPair<>(key,r1.getAttribute(key).getValue()));
        }


        //删除记录
//        ImmutableRecord r1 = menu.getRecordByPrimaryKey("29");

    }


}
