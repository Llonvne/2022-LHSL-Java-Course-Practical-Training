package database.commonProcs;

/**
 * 类名:     GetCustomerOrder
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class GetCustomerOrder {
    public static String SQL(String order_number){
        return "SELECT dish_name,dish_description,dish_price\n" +
            "FROM Menu,OrderedMenu\n" +
            "WHERE Menu.dish_number = OrderedMenu.dish_number";
    }
}
