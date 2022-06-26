package process;

import database.Init;
import database.TableGetter;
import database.table.types.Table;
import exec.Exec;
import exec.Tasks;
import ui.FormHandler;
import ui.UIOperations.MenuUIOperations;
import ui.displayables.StandardUIDisplay;

import java.sql.SQLException;

/**
 * 类名:     process.Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main<f> {
    public static Tasks tasks = new Tasks();

//        tasks.offer(new LoginTask().getLogin());
//        tasks.exec();


    public static void main(String[] args) throws SQLException {
        // 初始化数据库
        tasks.offer(new Init("OrderingSystem"));
        tasks.exec();
        Exec a = new FormHandler(new StandardUIDisplay("","",""),new MenuUIOperations());
        a.exec();
        Table menu = new TableGetter("菜品表").getTable();
//        MuteableRecord record = menu.getEmptyRecord();
//        record.updateAttribute(new KeyPair<>(record.getPrimaryKey(),String.valueOf(GetAvailablePrimarykey.getAvailablePrimarykey(menu.tableName(),record.getPrimaryKey()))));
//        menu.insertRecord(record);
//        ImmutableRecord r1 = menu.getRecordByPrimaryKey("28");
//        MuteableRecord r2 = menu.getEmptyRecord();
//        for (String key : r1.getKeys()){
//            r2.updateAttribute(new KeyPair<>(key,r1.getAttribute(key).getValue()));
//        }
//        r2.updateAttribute(new KeyPair<>("价格","120"));
//        menu.updateRecord(r2);
//        for (ImmutableRecord r : menu){
//            System.out.println(r);
//        }
    }
}
