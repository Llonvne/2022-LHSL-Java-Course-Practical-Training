package process;

public enum OrderStatus {
    RESERVE, // 预约
    TO_SHOP, // 到店
    WAITING, // 等待被叫号
    CALLING, // 正在叫号
    LATE,    // 迟到
    SEAT,    // 落座
    ORDERING,// 正在点菜
    ORDERED, // 点餐完毕
    TO_PAY,  // 付钱开始
    PAYING,  // 付钱开始
    AFTER_PAY,// 付钱完毕
    LEAVEING,// 离店
    OFF,    // 订单结束
    CANCELLED// 订单取消
}
